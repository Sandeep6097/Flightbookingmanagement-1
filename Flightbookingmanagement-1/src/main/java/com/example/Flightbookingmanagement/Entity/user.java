package com.example.Flightbookingmanagement.Entity;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="user")
public class user {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="userid", length=20)
	private long userid;
	
	@NotEmpty(message="First name can't be empty")
	@Column(name="first_name")
	@Size(min=2,max=10,message="Character limit exceed")
	private String first_name;
	
	
	@Column(name="last_name")
	@NotEmpty(message="Last name can't be empty")
	@Size(min=2, max=10,message="Character limit exceed")
	private String last_name;
	
	
	@NotEmpty(message="Username can't be empty")
	@Column(name="username")
	@Size(min=2,max=10,message="Character limit exceed")
	private String username;
	
	@NotNull(message="Password can't be empty")
	@Column(name="password")
	@Size(min=4, max=16,message="Character limit exceed")
	@Pattern(regexp="^[A-Za-z0-9]+$", message = "Password must contain only letters and digits")
	private String password;

	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<role> roles = new HashSet<>();

	
	
	
	public String getFirst_name() {
		return first_name;
	}

	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<role> getRoles() {
		return roles;
	}
	public void setRoles(Set<role> roles) {
		this.roles = roles;
	}

	public user()
	{
		
	}
	public user(long userid, String first_name, String last_name, String username, String password) {
		super();
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
