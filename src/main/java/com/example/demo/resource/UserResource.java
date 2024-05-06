package com.example.demo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.UserRecordDTO;
import com.example.demo.service.UserService;

//REST CONTROLLER DEIXA DISPONIVEL OS END POINTS (GET, PUT, DELET, POST...)

@RestController
@RequestMapping(value="/users")

public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserRecordDTO>> findAll(){	
		List<User> list = service.findAll();
		List<UserRecordDTO> listDTO = list.stream().map(x -> new UserRecordDTO(x.getId(),x.getName(),x.getEmail())).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	}

}
