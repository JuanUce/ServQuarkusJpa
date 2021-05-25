package com.programacion.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.programacion.pojos.Autor;

@Path("/")
@RegisterRestClient(configKey="autor-api")
public interface AutoresRest {

	@GET
    @Path("/{id}")
	public Autor GetAutor(@PathParam(value = "id") Long id);
	
	
	
}
