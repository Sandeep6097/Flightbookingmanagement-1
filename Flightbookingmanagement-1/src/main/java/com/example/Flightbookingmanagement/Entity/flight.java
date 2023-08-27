package com.example.Flightbookingmanagement.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table (name="flight")

public class flight {

	//CREATE TABLE flight(
	//flightid bigint not null AUTO_INCREMENT,
	//airline VARCHAR(50) default null,
	//Sources VARCHAR(50) default null,
	//destination VARCHAR(50) default null,
	//departure_time VARCHAR(50) default null,
	//arrival_time VARCHAR(50) default null,
	//duration Integer(10) default null,
	//capacity integer(10) default 80);
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long flightid;

	@NotNull(message="Airline is missinng")
	@Column(name="airline")
	private String airline;

	@NotNull(message="Source is missinng")
	@Column(name="source")
	private String source;

	@NotNull(message="Destination is missinng")
	@Column(name="destination")
	private String destination;

	@NotNull(message="Deprature Time is missinng")
	@Column(name="departure_time")
	private String departure_time;

	@NotNull(message="Arrival time is missinng")
	@Column(name="arrival_time")
	private String arrival_time;

	@NotNull(message="Duration of flight is missinng")
	@Column(name="duration")
	private int duration;

	@NotNull(message="Capacity of flight is missinng")
	@Column(name="capacity")
	private int capacity;

	public long getFlightid() {
		return flightid;
	}

	public void setFlightid(long flightid) {
		this.flightid = flightid;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
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

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public flight(long flightid, String airline, String source, String destination, String departure_time,
			String arrival_time, int duration, int capacity) {
		super();
		this.flightid = flightid;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.duration = duration;
		this.capacity = capacity;
	}

	public flight(){
		
	}

	@Override
	public String toString() {
		return "flight [flightid=" + flightid + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", duration="
				+ duration + ", capacity=" + capacity + "]";
	}
}
