package com.main.magazine.services;

import com.main.magazine.errors.BadRequestException;
import com.main.magazine.errors.NotFoundException;
import com.main.magazine.mapping.LoginMapping;
import com.main.magazine.model.User;
import com.main.magazine.payload.AuthenticationResponse;
import com.main.magazine.repositories.UserRepository;
import com.main.magazine.security.jwt.JwtProvider;
import com.main.magazine.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    // ******************************* METHODS | CRUD ******************************* //

    /* ************ Find | All ************** */
    public List<User> findAll() throws NotFoundException {
        List<User> users = this.userRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("Cannot find the stream of users.");
        } else {
            return users;
        }
    }

    /* ******** Find | One | By Id ********** */
    public User findById(Integer id) throws NotFoundException {
        return this.userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Cannot find the requested user.")
                );
    }

    /* *************** Store **************** */
    public void store(User user) throws BadRequestException {
        Optional<User> existingUser = this.userRepository.findByUsername(user.getUsername());
        Optional<User> existingEmail = this.userRepository.findByEmail(user.getEmail());

        // Password encryption
        user.setPassword(encodePassword(user.getPassword()));

        if (existingUser.isPresent() || existingEmail.isPresent()) {
            throw new BadRequestException("User already existing.");
        } else {
            this.userRepository.save(user);
        }

    }

    /* ************** Update **************** */
    public User update(Integer id, User user) throws NotFoundException {
        return this.userRepository.findById(id)
                .map(currentUser -> {
                    userData(currentUser, user); // Source => Destination
                    return this.userRepository.save(currentUser);
                })
                .orElseThrow(
                        () -> new NotFoundException("Cannot find the requested user.")
                );
    }

    /* ************** Destroy *************** */
    public void destroy(Integer id) throws NotFoundException {
        Optional<User> existingUser = this.userRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException("Cannot find the requested user.");
        } else {
            userRepository.deleteById(id);
            // Or : userRepository.findAll().remove(existingUser.get());
        }
    }

    // ******************************* AUTHENTICATION ******************************* //

    /* *************** Login **************** */
    public AuthenticationResponse login(LoginMapping loginMapping) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginMapping.getUsername(), loginMapping.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        String type = "Bearer";

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : userDetails.getAuthorities()) {
            String authority = grantedAuthority.getAuthority();
            roles.add(authority);
        }
        return new AuthenticationResponse(jwt,
                type,
                userDetails.getId(),
                userDetails.getName(),
                userDetails.getFirstname(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }

    // ******************************* MISCELLANEOUS ******************************** //
    private void userData(User source, User destination) {
        source.setName(destination.getName());
        source.setFirstname(destination.getFirstname());
        source.setUsername(destination.getUsername());
        source.setEmail(destination.getEmail());
        source.setPassword(encodePassword(destination.getPassword()));
        source.setRole(destination.getRole());
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
