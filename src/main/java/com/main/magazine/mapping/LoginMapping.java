package com.main.magazine.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LoginMapping {
	@NotBlank
	private String username;

	@NotBlank
	private String password;
}
