package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.security.JwtuserDetailsService;

@CrossOrigin
@RestController
public class JwtAuthenticateControllers {

	private List<Users> usuarios = new ArrayList<>();
	
	private String token;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private JwtuserDetailsService jwtUserDetailsSerice;
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String createAuthenticateToken(@RequestBody Users user) {
		
		usuarios = repository.findAll();
		
		for(Users usuario : usuarios) {
			if( usuario.getUsername().equals(user.getUsername())
				&& passwordEncoder.matches(user.getPassword(), usuario.getPassword()) ) {
				final UserDetails userDetails = jwtUserDetailsSerice.loadUserByUsername(user.getUsername());
				
				this.token = jwtTokenUtil.generateToken(userDetails);
				
			
				
				return this.token;
			}
		}
		return "Error";
	}
}




