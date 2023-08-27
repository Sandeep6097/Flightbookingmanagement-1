package com.example.Flightbookingmanagement.ServiceImp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Flightbookingmanagement.Entity.role;
import com.example.Flightbookingmanagement.Entity.user;

public class userPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private user user;

	public userPrincipal(user user) {

		this.user = user;
	}

	
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	
	public String getUsername() { // TODO Auto-generated method stub
		return user.getUsername();

	}

	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isCredentialsNonExpired() { // TODO Auto-generatedmethod stub

		return true;
	}

	
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
/*
 * return user.getroles().stream().map(role -> new
 * SimpleGrantedAuthority("role_" + role)) .collect(Collectors.toList());
 */