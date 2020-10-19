package com.main.magazine.security.services;

import com.main.magazine.model.User;
import com.main.magazine.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	// It gets ready to persist data through the AuthenticationManager
	// Source : https://dzone.com/articles/how-does-spring-transactional#:~:text=The%20transactional%20annotation%20itself%20defines%20the%20scope%20of%20a%20single%20database%20transaction.&text=The%20persistence%20context%20is%20just,persisted%20back%20into%20the%20database.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		// Build my personal UserDetail
		return UserDetailsImpl.build(user);
	}

}
