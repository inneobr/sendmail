package org.inneo.mail.model;

import org.inneo.mail.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_mail")
public class Mail extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Email
	@NotBlank
	@Column(name="para")
	private String to;
	
	@NotBlank
	@Column(name="titulo")
	private String subject;
	
	@NotBlank
	@Column(name="mensagem", columnDefinition = "TEXT")
	private String message;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="status_mail")
	StatusEmail statusMail;
}
