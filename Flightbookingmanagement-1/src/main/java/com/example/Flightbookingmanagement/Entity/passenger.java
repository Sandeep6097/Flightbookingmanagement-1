package com.example.Flightbookingmanagement.Entity;

import javax.persistence.*;

@Entity
@Table(name="passenger")
public class passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long passengerid;

	 @ManyToOne
	    @JoinColumn(name="flightid")
	    private flight flght;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phonenumber")
	private long phonenumber;

	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
		

	public flight getFlght() {
		return flght;
	}

	public void setFlght(flight flght) {
		this.flght = flght;
	}

	public long getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(long passengerid) {
		this.passengerid = passengerid;
	}

	public String getFirst_name() {
		return first_name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public passenger()
	{
		
	}

	public passenger(long passengerid, flight flght, String first_name, String last_name, String email,
			long phonenumber, String source, String destination) {
		super();
		this.passengerid = passengerid;
		this.flght = flght;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.source = source;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "passenger [passengerid=" + passengerid + ", flght=" + flght + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", phonenumber=" + phonenumber + ", source="
				+ source + ", destination=" + destination + "]";
	}
	
	

	
}

