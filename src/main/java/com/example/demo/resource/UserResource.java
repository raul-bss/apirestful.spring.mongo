package com.example.demo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

//REST CONTROLLER DEIXA DISPONIVEL OS END POINTS (GET, PUT, DELET, POST...)

@RestController
@RequestMapping(value="/users")

public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){	
	
		List<User> userList = service.findAll();
		List<UserDTO> userListDTO = userList.stream()
				.map(user -> new UserDTO(user))			
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(userListDTO);	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}

}
