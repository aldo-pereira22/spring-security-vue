package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;
	
	
	@GetMapping
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	
	public ResponseEntity<?> findById(@PathVariable Long id){
		return repository.findById(id)
				.map(response -> ResponseEntity.ok().body(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Users save(@RequestBody Users users) {
		return repository.save(users);
	}
	
	@RequestMapping( value = "{/id}", method = RequestMethod.PUT)
	public Users update(@RequestBody Users users, @PathVariable Long id) {
		users.setId(id);
		return repository.save(users);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		repository.deleteById(id);
		return null;
	}
	
	
}



