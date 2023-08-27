package com.example.Flightbookingmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flightbookingmanagement.Entity.flight;

public interface flightRepository extends JpaRepository<flight, Long>{

}
