package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.UsersDTO;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins ="*" )
public class UsersController {

	@Autowired
	private UsersService service;
	
	
	@GetMapping
	public List<UsersDTO> findAll(){
		
		return service.findAll().stream()
				.map( user -> new UsersDTO(user))
				.collect(Collectors.toList()); 
	}
	
	
	
	@GetMapping(path = {"/{id}"})
	public UsersDTO findById(@PathVariable Long id){
		Users user = service.findById(id);
		UsersDTO userDTO = new UsersDTO(user);
		return userDTO;
	}
	

	@PostMapping
	public ResponseEntity<Users> save(@RequestBody Users users ){
		users = service.save(users);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}")
				.buildAndExpand(users.getId()).toUri();
		
		return ResponseEntity.created(uri).body(users);
	}
	
	
	@RequestMapping(path  = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Users> update(@RequestBody Users users , @PathVariable Long id){
		users = service.update(users, id);
		return ResponseEntity.ok().body(users);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}









