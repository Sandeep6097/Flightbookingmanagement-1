package com.example.Flightbookingmanagement.Entity;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="booking")
public class booking {

	
//	booking_id (Primary key)
//	flight_id (Foreign key referencing Flight table)
//	passenger_id (Foreign key referencing Passenger table)
//	booking_datey
//	status (e.g., confirmed, canceled)
//	seat_number
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long bookingid;
	

	    @ManyToOne
	    @JoinColumn(name = "passengerid")
	    private passenger pass;

	    @Temporal(TemporalType.DATE)
	    @Column(name = "booking_date")
	    private Date bookingDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="seatno")
	private String seatno;

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public passenger getPass() {
		return pass;
	}

	public void setPass(passenger pass) {
		this.pass = pass;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public booking(long bookingid, passenger pass, Date bookingDate, String status, String seatno) {
		super();
		this.bookingid = bookingid;
		this.pass = pass;
		this.bookingDate = bookingDate;
		this.status = status;
		this.seatno = seatno;
	}
	
	public booking()
	{
		
	}

	@Override
	public String toString() {
		return "booking [bookingid=" + bookingid + ", pass=" + pass + ", bookingDate=" + bookingDate + ", status="
				+ status + ", seatno=" + seatno + "]";
	}

	
	
}
