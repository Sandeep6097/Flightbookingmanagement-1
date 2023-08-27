package com.example.Flightbookingmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flightbookingmanagement.Entity.booking;

public interface bookingRepository extends JpaRepository<booking, Long>{

}
