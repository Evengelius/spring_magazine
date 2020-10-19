package com.main.magazine.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class AuthenticationResponse {
	private String token;
	private String type;
	private Integer id;
	private String name;
	private String firstname;
	private String username;
	private String email;
	private List<String> role;
}
