package com.main.magazine.security;

import com.main.magazine.security.cors.CorsFilter;
import com.main.magazine.security.jwt.AuthEntryPointJwt;
import com.main.magazine.security.jwt.JwtAuthenticationFilter;
import com.main.magazine.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final AuthEntryPointJwt unauthorizedHandler;
	private final UserDetailsServiceImpl userDetailsService;

	// ********************************* CONSTRUCTOR ********************************* //

	@Autowired
	public WebSecurityConfig(AuthEntryPointJwt unauthorizedHandler, UserDetailsServiceImpl userDetailsService) {
		this.unauthorizedHandler = unauthorizedHandler;
		this.userDetailsService = userDetailsService;
	}

	// ******************************* Authentication ******************************** //
	/**
	 * The Authentication is handled through a service : UserDetailsService <br />
	 * The handle is made through a service : UserDetailsService. <br />
	 * ----------------------<br />
	 * <strong>How does it work?</strong><br />
	 * It has an interface called <strong>Authentication</strong>,<br />
	 * And by calling it : <em><strong>.authenticate</strong>(new UsernamePasswordAuthenticationToken(username, password)),</em><br />
	 * It is passing the UsernamePasswordAuthenticationToken to the default AuthenticationProvider,<br />
	 * Which will use the userDetailsService to get the user based on username, <em>loadByUsername()</em>,<br />
	 * And compare that user's password with the one in the authentication token.<br />
	 * Finally if successful, <br />
	 * The AuthenticationManager will return  a fully populated Authentication object, (including granted authorities).
	 */
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	// ******************************** Authorization ******************************** //
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
				.antMatchers("/api/users/**").permitAll()
				.antMatchers("/api/roles/**").permitAll()
				.antMatchers("/api/**").permitAll()
				.anyRequest().authenticated();

		// JWT Authentication
		http.addFilterBefore(JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		// CORS
		http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
	}

	// ************************************ BEANS ************************************ //

	@Bean
	public JwtAuthenticationFilter JwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
