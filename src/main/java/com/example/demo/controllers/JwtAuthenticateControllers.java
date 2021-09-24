package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
import com.example.demo.security.requests.JwtRequest;

@CrossOrigin
@RestController
public class JwtAuthenticateControllers {

	private List<Users> usuarios = new ArrayList<>();
	private String token;
	private Long id;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private JwtuserDetailsService jwtUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Optional<Users> createAuthenticateToken(@RequestBody Users authenticateRequest) throws Exception {
		usuarios = repository.findAll();
		
		for(Users usuario : usuarios) {
			System.out.println(usuario.getPassword());
			if( usuario.getUsername().equals(authenticateRequest.getUsername())
					&& passwordEncoder.matches(authenticateRequest.getPassword(), usuario.getPassword()) ) {
//				authenticate(authenticateRequest.getUsername(), authenticateRequest.getPassword());
				

				final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(usuario.getUsername());
				System.out.println(userDetails);
			
				this.token = jwtTokenUtil.generateToken(userDetails);
				this.id = usuario.getId();
//				return this.token;

			}
		}
		Optional<Users> obj = null;
		obj = repository.findById(this.id);
		obj.orElseThrow().setToken(token);
		obj.orElseThrow().setPassword("");
		return obj;
	}
	
	private void authenticate(String username, String password) throws Exception{
		System.out.println(username + " "+password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}




