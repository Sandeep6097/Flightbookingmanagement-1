package com.example.Flightbookingmanagement.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flightbookingmanagement.Entity.passenger;

public interface passengerRepository extends JpaRepository<passenger, Long>{
	
	 Optional<passenger> findBySourceAndDestination(String source, String destination);
	 
	

}

