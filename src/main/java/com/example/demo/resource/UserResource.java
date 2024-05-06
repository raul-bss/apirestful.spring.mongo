package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

//REST CONTROLLER DEIXA DISPONIVEL OS END POINTS (GET, PUT, DELET, POST...)

@RestController
@RequestMapping(value="/users")

public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){	
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}

}
