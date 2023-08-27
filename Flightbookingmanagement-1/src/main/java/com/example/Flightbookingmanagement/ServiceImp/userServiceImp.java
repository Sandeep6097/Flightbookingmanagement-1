package com.example.Flightbookingmanagement.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Flightbookingmanagement.Entity.user;
import com.example.Flightbookingmanagement.Exception.UserNotFoundException;
import com.example.Flightbookingmanagement.Repository.userRepository;


import java.util.*;


	@Service
	public class userServiceImp implements UserDetailsService {

		@Autowired
		userRepository userRepository;

		
		public userPrincipal loaduserByusername(String username) throws UsernameNotFoundException { // TODO Auto-generated
																									// method stub
			user user = userRepository.findByUsername(username);

			if (user == null) {
				throw new UsernameNotFoundException("user not found");
			}

			return new userPrincipal(user);

		}

		public user adduser(user user) {
			// TODO Auto-generated method stub

			return userRepository.save(user);
		}

		public user getByusername() {
			// TODO Auto-generated method stub
			return userRepository.findByUsername(null);
		}

		public List<user> getAlluser() {
			// TODO Auto-generated method stub
			return userRepository.findAll();
		}

		public user updateuser(user user) throws UserNotFoundException {
			// TODO Auto-generated method stub

			Optional<user> optional = userRepository.findById((long) user.getUserid());

			if (optional.isPresent()) {
				user _user = userRepository.findById(user.getUserid()).get();
				_user.setUsername(user.getUsername());
				_user.setPassword(user.getPassword());
				_user.setRoles(user.getRoles());

				return userRepository.save(_user);
			} else {
				throw new UserNotFoundException("user not found with the matching ID!");
			}

			// return optional.get();
		}

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}

//		@Override
//		public void deleteDoctor(int id) throws DoctorNotFoundException {
//			// TODO Auto-generated method stub
//			Optional<Doctor> d = doctorRepository.findById(id);
	//
//			if (d.isPresent()) {
//				doctorRepository.deleteById(id);
//			} else {
//				throw new DoctorNotFoundException("Doctor not found with the matching ID!");
//			}

	}


