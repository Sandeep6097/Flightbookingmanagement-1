package com.example.Flightbookingmanagement.Service;


import java.util.*;

import com.example.Flightbookingmanagement.Entity.flight;
import com.example.Flightbookingmanagement.Exception.FlightNotFoundException;

public interface flightService {
	public flight addflight(flight flight);
	
	public flight addmanyflight(flight flight);

	public static List<flight> getAllflight() {
		// TODO Auto-generated method stub
		return null;
	}

	public static flight findflightById(long flightid) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public static flight updateflight(flight flightid) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteflight(long flightid) throws FlightNotFoundException;

	
}
