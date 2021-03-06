package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	private String senhaHash;

	
	@Autowired
	private UsersRepository repository;
	
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	
	public Users findById( Long id){
		Optional<Users> obj = repository.findById(id);
		return obj.get();

	}
	

	public Users save( Users user) {
		this.senhaHash = passwordEnconder.encode(user.getPassword());
		user.setPassword(this.senhaHash);
		return repository.save(user);
	}
	
	
	public Users update( Users users,  Long id) {
		users.setId(id);
		return repository.save(users);
	}
	

	public ResponseEntity<?> delete( Long id){
		
		repository.deleteById(id);
		return null;
	}
	
	
}



