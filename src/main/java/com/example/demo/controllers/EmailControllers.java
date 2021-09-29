package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EmailDTO;
import com.example.demo.services.EmailService;

@RestController
@RequestMapping({"/email"})
public class EmailControllers {
	
	@Autowired
	private EmailService emailService;
	
	@CrossOrigin
	@PostMapping
	public String sendEmail(@RequestBody EmailDTO emailDTO) {
		
		emailService.send(emailDTO.getEmailTO(), emailDTO.getSubject(), emailDTO.getText());
		return "Mensagem enviada com sucesso";
	}
	
}
