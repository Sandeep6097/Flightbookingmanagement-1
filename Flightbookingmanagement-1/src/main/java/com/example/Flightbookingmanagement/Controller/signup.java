package com.example.Flightbookingmanagement.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flightbookingmanagement.Entity.role;
import com.example.Flightbookingmanagement.Entity.user;
import com.example.Flightbookingmanagement.ServiceImp.userServiceImp;

import javax.validation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class signup {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private userServiceImp userDetailsService;

	@PostMapping(path = "/signup") //
	public ResponseEntity<Object> createUser(@RequestBody @Valid user user) {
		// Map<String, String> errors = new HashMap<>();
		// String field = null;
		// String message = null;
		// try {
		String pwd = user.getPassword();
		String bcryptpwd = passwordEncoder.encode(pwd);
		user.setPassword(bcryptpwd);
		Set<role> roles = new HashSet<>();
		roles.add(new role(2, "USER"));
		user.setRoles(roles);
		user savedUser = userDetailsService.adduser(user);
		return new ResponseEntity<Object>(savedUser, HttpStatus.CREATED);
	}
}