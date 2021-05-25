package com.programacion.config;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class ChequeoHealth implements HealthCheck{

	@ConfigProperty(name = "saludo.mensaje", defaultValue = "Saludo Server Libros")
    private String saludo;
	
	
	@Override
	public HealthCheckResponse call() {
		
		System.out.println("...->Ping");
		return HealthCheckResponse.named("Cheque Simple servidor Autor")
				.up()
				.withData("mensaje", saludo)
				.build();
	}

	
	
}
