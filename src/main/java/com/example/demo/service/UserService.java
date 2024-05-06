package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.exception.ObjectNotFound;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow( ()-> new ObjectNotFound("Id not found "));
	}

}
