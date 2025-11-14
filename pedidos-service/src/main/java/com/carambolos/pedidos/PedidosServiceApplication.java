package com.carambolos.pedidos;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
		info = @Info(
				title = "API Pedidos - Carambolos",
				version = "v1",
				description = "Microserviço de Pedidos"
		),
		servers = {
				@Server(url = "http://localhost:8084", description = "Servidor Local")
		}
)
@SpringBootApplication
@EnableFeignClients
public class PedidosServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.filename("dev.env")
				.ignoreIfMissing()
				.load();

		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
		System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));

		SpringApplication.run(PedidosServiceApplication.class, args);
	}
}