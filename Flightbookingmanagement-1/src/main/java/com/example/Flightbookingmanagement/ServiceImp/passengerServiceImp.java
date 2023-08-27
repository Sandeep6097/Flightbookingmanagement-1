package com.example.Flightbookingmanagement.ServiceImp;


import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Flightbookingmanagement.Entity.passenger;
import com.example.Flightbookingmanagement.Exception.PassengerNotFoundException;
import com.example.Flightbookingmanagement.Repository.passengerRepository;
import com.example.Flightbookingmanagement.Service.passengerService;

@Service
public abstract class passengerServiceImp implements passengerService {
	@Autowired
	passengerRepository passengerRepository;

	@Override
	public passenger addpassenger(passenger passenger) {
		// TODO Auto-generated method stub
		return passengerRepository.save(passenger);
	}
	@Override
	public passenger addmanypassenger(passenger passenger) {
		// TODO Auto-generated method stub
		
		return passengerRepository.save(passenger);
	}

	public List<passenger> getAllpassenger() {
		// TODO Auto-generated method stub
		return passengerRepository.findAll();
	}

	public passenger findpassengerById(long id) throws PassengerNotFoundException {
		// TODO Auto-generated method stub

		Optional<passenger> optional = passengerRepository.findById((long) id);

		if (optional.isPresent()) {
			return passengerRepository.findById((long) id).get();
		} else {
			throw new PassengerNotFoundException("Passenger not found with the matching ID!");
		}
	}

	public passenger updatepassenger(passenger passenger) throws PassengerNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Optional<passenger> optional = passengerRepository.findById(passenger.getPassengerid());

		if (optional.isPresent()) {
			passenger _passenger = passengerRepository.findById(passenger.getPassengerid()).get();
			_passenger.setFlght(passenger.getFlght());
			_passenger.setFirst_name(passenger.getFirst_name());
			_passenger.setEmail(passenger.getEmail());
			_passenger.setLast_name(passenger.getLast_name());
			_passenger.setPhonenumber(passenger.getPhonenumber());
			_passenger.setSource(passenger.getSource());
			_passenger.setDestination(passenger.getDestination());
			return passengerRepository.save(_passenger);
		} else {
			throw new PassengerNotFoundException("Passenger not found with the matching ID!");
		}
	}

	public void deletepassenger(long id) throws PassengerNotFoundException {
		// TODO Auto-generated method stub

		Optional<passenger> e = passengerRepository.findById((long) id);

		if (e.isPresent()) {
			passengerRepository.deleteById((long) id);
		} else {
			throw new PassengerNotFoundException("Passenger not found with the matching ID!");
		}

	}
	
	}