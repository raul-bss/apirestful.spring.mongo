package com.example.demo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

//REST CONTROLLER DEIXA DISPONIVEL OS END POINTS (GET, PUT, DELET, POST...)

@RestController
@RequestMapping(value="/users")

public class UserResourceT {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1","maria","maria@gmail.com");
		User alex = new User("2","pedro","pedro@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		
		return ResponseEntity.ok().body(list);
		
	}

}
