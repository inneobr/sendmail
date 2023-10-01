package org.inneo.mail.dto;

import org.inneo.mail.enums.StatusEmail;
import org.inneo.mail.model.Mail;

public record MailDto(String to, String subject, String message, StatusEmail status) {
	public MailDto(Mail mail){
		this(mail.getTo(), mail.getSubject(), mail.getMessage(), mail.getStatusMail());
    }
}
