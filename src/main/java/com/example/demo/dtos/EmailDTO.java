package com.example.demo.dtos;

import org.springframework.stereotype.Component;

@Component
public class EmailDTO {

	private String emailTo;
	private String subject;
	private String text;
	
	
	public EmailDTO() {
		// TODO Auto-generated constructor stub
	}


	public EmailDTO(String emailTO, String subject, String text) {
		this.emailTo = emailTO;
		this.subject = subject;
		this.text = text;
	}


	public String getEmailTO() {
		return emailTo;
	}


	public void setEmailTO(String emailTO) {
		this.emailTo = emailTO;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
