package com.main.magazine.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.magazine.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private final Integer id;

	private final String name;

	private final String firstname;

	private final String username;

	private final String email;

	@JsonIgnore
	private final String password;

	private final Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String name, String firstname, String username, String email, String password,
						   Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();

		String ROLE_PREFIX = "ROLE_";
		authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole().toUpperCase()));

		return new UserDetailsImpl(
				user.getId(),
				user.getName(),
				user.getFirstname(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	public String getName() { return name;
	}
	public String getFirstname() { return firstname; }

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
