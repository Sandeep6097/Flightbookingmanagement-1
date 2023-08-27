package com.example.Flightbookingmanagement.ServiceImp;


import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Flightbookingmanagement.Entity.flight;
import com.example.Flightbookingmanagement.Exception.FlightNotFoundException;
import com.example.Flightbookingmanagement.Repository.flightRepository;
import com.example.Flightbookingmanagement.Service.flightService;

@Service
public class flightServiceImp implements flightService {
	@Autowired
	flightRepository flightRepository;

	@Override
	public flight addflight(flight flight) {
		// TODO Auto-generated method stub
		return flightRepository.save(flight);
	}

	public List<flight> getAllflight() {
		// TODO Auto-generated method stub
		return flightRepository.findAll();
	}

	
	public flight findflightById(int id) throws FlightNotFoundException {
		// TODO Auto-generated method stub

		Optional<flight> optional = flightRepository.findById((long) id);

		if (optional.isPresent()) {
			return flightRepository.findById((long) id).get();
		} else {
			throw new FlightNotFoundException("flight not found with the matching ID!");
		}
	}


	public flight updateflight(flight flight) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Optional<flight> optional = flightRepository.findById(flight.getFlightid());

		if (optional.isPresent()) {
			flight _flight = flightRepository.findById(flight.getFlightid()).get();
			_flight.setAirline(flight.getAirline());
			_flight.setSource(flight.getSource());
			_flight.setDestination(flight.getDestination());
			_flight.setDeparture_time(flight.getDeparture_time());
			_flight.setArrival_time(flight.getArrival_time());
			_flight.setDuration(flight.getDuration());
			_flight.setCapacity(flight.getCapacity());
			return flightRepository.save(_flight);
		} else {
			throw new FlightNotFoundException("flight not found with the matching ID!");
		}
	}

	
	public void deleteflight(long id) throws FlightNotFoundException {
		// TODO Auto-generated method stub

		Optional<flight> e = flightRepository.findById((long) id);

		if (e.isPresent()) {
			flightRepository.deleteById((long) id);
		} else {
			throw new FlightNotFoundException("flight not found with the matching ID!");
		}

	}

	@Override
	public flight addmanyflight(flight flight) {
		// TODO Auto-generated method stub
		return flightRepository.save(flight);
	}

	
}
