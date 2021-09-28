package com.example.demo.dtos;

import com.example.demo.entities.Users;

public class UsersDTO {

	private Long id;
	private String email;
	private String username;
	
	
	public UsersDTO() {

	}
	
	public UsersDTO(Users users) {
		this.id = users.getId();
		this.email = users.getEmail();
		this.username = users.getUsername();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
