package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@CrossOrigin
@RestController
public class JwtAuthenticateControllers {

	private List<Users> usuarios = new ArrayList<>();
	
	@Autowired
	private UsersRepository repository;
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String createAuthenticateToken(@RequestBody Users user) {
		
		usuarios = repository.findAll();
		
		for(Users usuario : usuarios) {
			if( usuario.getUsername().equals(user.getUsername()) && usuario.getPassword().equals(user.getPassword())) {
				
				return user.getUsername();
			}
		}
		return "Error";
	}
}




