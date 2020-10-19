package com.main.magazine.controllers;

import com.main.magazine.errors.BadRequestException;
import com.main.magazine.errors.NotFoundException;
import com.main.magazine.mapper.UserMapper;
import com.main.magazine.mapping.LoginMapping;
import com.main.magazine.mapping.UserMapping;
import com.main.magazine.model.User;
import com.main.magazine.payload.AuthenticationResponse;
import com.main.magazine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserMapper userMapper;
	private final UserService userService;

	@Autowired
	public UserController(UserMapper userMapper, UserService userService) {
		this.userMapper = userMapper;
		this.userService = userService;
	}

	// ******************************* GET ******************************* //

	// User  All
	@GetMapping
	public List<UserMapping> findAll() throws NotFoundException {
		return this.userMapper.entityListToDto(userService.findAll());
	}

	// User | Find One | By Id
	@GetMapping("/{id}")
	public UserMapping findById(@PathVariable @Positive Integer id) throws NotFoundException {
		return this.userMapper.entityToDto(this.userService.findById(id));

	}

	// ******************************* POST ****************************** //
	@PostMapping
	/*
	 * @Valid tells Spring Boot to automatically instantiate a Validator, and to validate the object : Article here.
	 * This check is performed before the method body is executed.
	 * If the validation fails, the method will throw a MethodArgumentNotValidException,
	 * which is mapped to the 400 Bad Request response status by default
	 */
	public ResponseEntity<Void> create(@Valid @RequestBody User user) throws BadRequestException {
		this.userService.store(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// ******************************* PUT ******************************* //

	// User | Update
	@PutMapping("/{id}")
	public UserMapping edit(@PathVariable Integer id, @RequestBody User user) throws NotFoundException {
		return this.userMapper.entityToDto(this.userService.update(id, user));
	}

	// ****************************** DELETE ***************************** //

	// User | Destroy
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		this.userService.destroy(id);
	}

	// ************************* Authentication ************************** //

	@PostMapping("/login")
	public AuthenticationResponse login(@Valid @RequestBody LoginMapping loginMapping) {
		return this.userService.login(loginMapping);
	}
}
