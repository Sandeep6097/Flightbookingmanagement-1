package com.example.Flightbookingmanagement.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.Flightbookingmanagement.Entity.booking;
import com.example.Flightbookingmanagement.Repository.bookingRepository;

@RestController
@RequestMapping("/api")
public class bookingController {
	@Autowired
	bookingRepository bookingRepository;
	

	@PostMapping("/bookings")
	public String createNewbooking(@RequestBody booking book) {
		bookingRepository.save(book);
		return "ticket booked successfully";
	}
	
	@GetMapping("/bookings")
	public ResponseEntity<List<booking>> getAllbooking(){
		List<booking> bookinglist=new ArrayList<>();
		bookingRepository.findAll().forEach(bookinglist::add);
		return new ResponseEntity<List<booking>>(bookinglist,HttpStatus.OK);
	}
	
	@GetMapping("/bookings/{bookingid}")
	public ResponseEntity<booking> getflightbyid(@PathVariable long bookingid){
		Optional<booking> book=bookingRepository.findById(bookingid);
		if(book.isPresent())
		{
			return new ResponseEntity<booking>(book.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<booking>(HttpStatus.NOT_FOUND);

		}
		
	}
	

	@PutMapping("/bookings/{bookingid}")
	public String updateFlightById(@PathVariable long bookingid,@RequestBody booking booking) {
		Optional<booking> book=bookingRepository.findById(bookingid);
		if(book.isPresent())
		{
			booking existbook=book.get();
			existbook.setBookingDate(booking.getBookingDate());
			existbook.setStatus(booking.getStatus());
			existbook.setSeatno(booking.getSeatno());
			bookingRepository.save(existbook);
			return "details has been update for id "+bookingid;
		}
		else
		{
			return "details has not been update for id "+bookingid;
		}
	}
	
	@DeleteMapping("/bookings/{bookingid}")
	public String deleteFightById(@PathVariable long bookingid)
	{
		bookingRepository.deleteById(bookingid);
		return "flight of id "+bookingid+" deleted successfully";
	}
	
}
