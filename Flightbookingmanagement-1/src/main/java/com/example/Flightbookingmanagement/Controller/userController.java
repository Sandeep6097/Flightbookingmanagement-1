package com.example.Flightbookingmanagement.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flightbookingmanagement.Entity.user;
import com.example.Flightbookingmanagement.Exception.UserNotFoundException;
import com.example.Flightbookingmanagement.ServiceImp.userServiceImp;

import javax.validation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class userController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private userServiceImp userDetailsService;

	@PostMapping(path = "/users") //
	public ResponseEntity<Object> createUser(@RequestBody @Valid user user) {
		Map<String, String> errors = new HashMap<>();
		String field = null;
		String message = null;
		try {
			String pwd = user.getPassword();
			String bcryptpwd = passwordEncoder.encode(pwd);
			user.setPassword(bcryptpwd);

			user saveduser = userDetailsService.adduser(user);
			return new ResponseEntity<Object>(saveduser, HttpStatus.CREATED);
		} catch (Exception ex) {

			errors.put(field, message);
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

		}

	}

	@PutMapping("/users")
	public user updateuser(@RequestBody user user) throws UserNotFoundException {
		return userDetailsService.updateuser(user);
	}

	@GetMapping("/users")
	public List<user> findAllusers() {
		return userDetailsService.getAlluser();
	}

	@GetMapping("/users/{username}")
	public user findByusername() {
		return userDetailsService.getByusername();
	}

}
