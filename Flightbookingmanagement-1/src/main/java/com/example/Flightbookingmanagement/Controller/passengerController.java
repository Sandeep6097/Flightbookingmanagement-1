package com.example.Flightbookingmanagement.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flightbookingmanagement.Entity.passenger;
import com.example.Flightbookingmanagement.Exception.PassengerNotFoundException;
import com.example.Flightbookingmanagement.Repository.passengerRepository;
import com.example.Flightbookingmanagement.Service.passengerService;

@RestController
@RequestMapping("/api")
public class passengerController {
	@Autowired
	passengerRepository passengerRepository;
	
	@PostMapping("/passengers")

		public ResponseEntity<Object> createNewPassenger(@RequestBody passenger pass) {
			Map<String, String> errors = new HashMap<>();
			String field = null;
			String message = null;
			try {
				passenger savedpassenger = new passenger();
			return new ResponseEntity<Object>(savedpassenger, HttpStatus.CREATED);
			}
			catch(Exception ex) {
			errors.put(field, message);
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

		}

	}
	

	@PostMapping("/manypassengers")

		public ResponseEntity<Object> createmanyNewPassenger(@RequestBody  passenger pass) {
			Map<String, String> errors = new HashMap<>();
			String field = null;
			String message = null;
			try {
				passenger savedpassenger = new passenger();
			return new ResponseEntity<Object>(savedpassenger, HttpStatus.CREATED);
			}
			catch(Exception ex) {
			errors.put(field, message);
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

		}

	
	}
	
	@GetMapping("/passengers")

	public List<passenger> getAllpassenger()throws PassengerNotFoundException{
			return passengerService.getAllpassenger();
	}
			
	@GetMapping("/passengers/{passengerid}")
	public passenger findpassengerById(@PathVariable long passengerid) throws PassengerNotFoundException{
			return passengerService.findpassengerById(passengerid);

	}

	@PutMapping("/passengers/{passengerid}")
	public passenger updatePassengerById(@PathVariable long passengerid,@RequestBody passenger passenger) throws PassengerNotFoundException {
		
			return passengerService.updatepassenger(passenger);
		
	}
	
	@DeleteMapping("/passengers/{passengerid}")
	public String deleteFightById(@PathVariable long passengerid)throws PassengerNotFoundException
	{
		passengerRepository.deleteById(passengerid);
		return "passenger detail of id "+passengerid+" deleted successfully";
	}

}
