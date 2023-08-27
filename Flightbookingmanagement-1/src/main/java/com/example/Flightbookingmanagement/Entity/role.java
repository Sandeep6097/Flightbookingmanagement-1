package com.example.Flightbookingmanagement.Entity;


import javax.persistence.*;


@Entity
@Table(name = "role")
public class role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;
	
	@Column(name = "role")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public role()
	{
		
	}

	public role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	@Override
	public String toString() {
		return "role [id=" + id + ", role=" + role + "]";
	}
	
}
