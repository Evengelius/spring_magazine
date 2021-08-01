package com.main.magazine.security.jwt;

import com.main.magazine.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			// Retrieve the token from the request url
			String jwt = parseJwt(request);

			// If the token exist and is valid
			if (jwt != null && jwtProvider.validateJwtToken(jwt)) {
				// Get the username from the token
				String username = jwtProvider.getClaimsAndSubjectFromJwtToken(jwt);
				// Find the user of the token & and load him/her for authentication
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				// Authenticate the user with his details coming from the JwtProvider, at line 31.
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				// Stores additional details for the authentication request
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// Authenticate the user
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {0}", e);
		}

		filterChain.doFilter(request, response);
	}

	// ********************** JWT | Get The Token From The Request *********************** //
	private String parseJwt(HttpServletRequest request) {

		/*
		 * 1. Retrieve the header's token
		 * 2. Check that the header exist and starts with "Bearer "
		 * 3. Return the header's text starting from the seven position : so without "Bearer "
		 */

		String headerAuth = request.getHeader("Authorization"); // 1.

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) { // 2.
			return headerAuth.substring(7); // 3.
		}
		return null;
	}
}
