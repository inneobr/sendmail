package org.inneo.mail.service;

import org.inneo.mail.dto.MailDto;
import org.inneo.mail.enums.StatusEmail;
import org.inneo.mail.model.Mail;
import org.inneo.mail.repository.EmailRep;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {
	private final EmailRep mailRep;
	private final JavaMailSender mailSender;
	
	public void sending(MailDto mailDto) {
		Mail email = new Mail();
		BeanUtils.copyProperties(mailDto, email);
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();	    
			message.setFrom("inneobr@gmail.com");
	        message.setTo(email.getTo());
	        message.setSubject(email.getSubject());
	        message.setText(email.getMessage());
	        mailSender.send(message);
	        
	        email.setStatusMail(StatusEmail.SEND);
	    } catch (MailException e){
	    	email.setStatusMail(StatusEmail.NOTSEND);
		}		
		mailRep.save(email);			
	}

}
