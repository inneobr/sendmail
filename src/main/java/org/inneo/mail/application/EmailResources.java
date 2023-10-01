package org.inneo.mail.application;

import org.inneo.mail.dto.MailDto;
import lombok.RequiredArgsConstructor;
import org.inneo.mail.service.EmailService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/sendmail")
@Tag(name = "Email", description = "Send mail.")
public class EmailResources {
	private final EmailService emailService;
	
	@Operation(summary = "send", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Enviado com sucesso." ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	
	@PostMapping
	public ResponseEntity<?> sending(@RequestBody MailDto emailDto) {
		try{
			emailService.sending(emailDto);
			return ResponseEntity.ok().body("Enviado com sucesso.");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("Email não enviado.");
		}	  
	}

}
