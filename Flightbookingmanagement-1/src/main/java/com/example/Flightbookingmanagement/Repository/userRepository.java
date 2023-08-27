package com.example.Flightbookingmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flightbookingmanagement.Entity.user;

public interface userRepository extends JpaRepository<user, Long>{

	public user findByUsername(String username);
}

