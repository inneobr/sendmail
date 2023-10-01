package org.inneo.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*")
@Tag(name = "Application", description = "Verificação de status.")
public class RunApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	}
	
	@Operation(summary = "status atual", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Requisição executada com sucesso!" ),
			@ApiResponse(responseCode = "400", description = "Requisição falhou." ),
			@ApiResponse(responseCode = "401", description = "Permissão negada!" )
	})
	
	@GetMapping
	public Servico status() {
		return new Servico("Email application is running", true);
	}

}

@Data
class Servico{	
	private String message;
	private boolean status;
	
	public Servico(String message, boolean status) {
		this.message = message;
		this.status = status;
	}
}
