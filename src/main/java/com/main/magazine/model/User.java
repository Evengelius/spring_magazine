package com.main.magazine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email")
		})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * <strong>@Column</strong> <br />
	 * Only specifies table column properties as it doesn't provide validations. <br />
	 * --------------------------------<br />
	 * <strong>@Size | @NotBlank | Etc.</strong> <br />
	 * Are bean validation annotation
	 */

	@Size(max = 20) @NotBlank
	@Column(length = 20, nullable = false)
	private String name;

	@Size(max = 20) @NotBlank
	@Column(length = 20, nullable = false)
	private String firstname;

	@Size(max = 30) @NotBlank
	@Column(length = 30, nullable = false)
	private String username;

	@Size(max = 50) @NotBlank @Email
	@Column(length = 50, nullable = false)
	private String email;

	@Size(max = 255) @NotBlank
	@Column(nullable = false)
	private String password;

	@Size(max = 30) @NotBlank
	@Column(length = 30, nullable = false)
	private String role = "user";

	public User(String name, String firstname, String username, String email, String password) {
		this.name = name;
		this.firstname = firstname;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
