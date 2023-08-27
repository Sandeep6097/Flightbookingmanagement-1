package com.example.Flightbookingmanagement.Service;


import java.util.*;

import com.example.Flightbookingmanagement.Entity.passenger;
import com.example.Flightbookingmanagement.Exception.PassengerNotFoundException;

public interface passengerService {
	public passenger addpassenger(passenger passenger);
	
	public passenger addmanypassenger(passenger passenger);

	public static List<passenger> getAllpassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	public static passenger findpassengerById(long passengerid) throws PassengerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public static passenger updatepassenger(passenger passengerid) throws PassengerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletepassenger(long passengerid) throws PassengerNotFoundException;

	
}
