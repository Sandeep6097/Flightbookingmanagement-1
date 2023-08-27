package com.example.Flightbookingmanagement.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.Flightbookingmanagement.Entity.flight;
import com.example.Flightbookingmanagement.Exception.FlightNotFoundException;
import com.example.Flightbookingmanagement.Repository.flightRepository;
import com.example.Flightbookingmanagement.Service.flightService;

@RestController
@RequestMapping("/api")
public class flightController {
	@Autowired
	flightRepository flightRepository;
	
	@PostMapping("/flights")

		public ResponseEntity<Object> createNewPassenger(@RequestBody flight pass) {
			Map<String, String> errors = new HashMap<>();
			String field = null;
			String message = null;
			try {
				flight savedflight = new flight();
			return new ResponseEntity<Object>(savedflight, HttpStatus.CREATED);
			}
			catch(Exception ex) {
			errors.put(field, message);
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

		}

	}
	

	@PostMapping("/manyflights")

		public ResponseEntity<Object> createmanyNewPassenger(@RequestBody  flight pass) {
			Map<String, String> errors = new HashMap<>();
			String field = null;
			String message = null;
			try {
				flight savedflight = new flight();
			return new ResponseEntity<Object>(savedflight, HttpStatus.CREATED);
			}
			catch(Exception ex) {
			errors.put(field, message);
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

		}

	
	}
	
	@GetMapping("/flights")

	public List<flight> getAllpassenger()throws FlightNotFoundException{
			return flightService.getAllflight();
	}
			
	@GetMapping("/flights/{flightid}")
	public flight findpassengerById(@PathVariable long passengerid) throws FlightNotFoundException{
			return flightService.findflightById(passengerid);

	}

	@PutMapping("/flights/{passengerid}")
	public flight updatePassengerById(@PathVariable long passengerid,@RequestBody flight flight) throws FlightNotFoundException {
		
			return flightService.updateflight(flight);
		
	}
	
	@DeleteMapping("/flights/{flightid}")
	public String deleteFightById(@PathVariable long flightid)throws FlightNotFoundException
	{
		flightRepository.deleteById(flightid);
		return "flight detail of id "+flightid+" deleted successfully";
	}

}
