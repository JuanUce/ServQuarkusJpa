package com.programacion.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.programacion.pojos.Libro;
import com.programacion.servicios.ServicioLibro;

import io.opentracing.Tracer;

@Path("/libros")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
@ApplicationScoped
public class LibroRest {
	
	//@Inject
	//@ConfigProperty(name = "configsource.consul.host", defaultValue = "127.0.0.1")
//	private String consulHost;

	//@Inject
	//@ConfigProperty(name = "app.name")
//	private String appName;

	//@Inject
	//@ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
	//private Integer appPort;

	//@Inject
	//Tracer tracer;

	
	
	
	@Inject
	ServicioLibro servicio;
	
	@GET
	public List<Libro> listLibros(){
	//tracer.activeSpan().setTag("puerto", appPort);
	//tracer.activeSpan().setTag("ip", consulHost);
	return servicio.listarLibros();	
		
		}
	
	
	@GET
	@Path("/{id}")
	public Libro LibroById(@PathParam("id") Long id) {
		//	tracer.activeSpan().setTag("puerto", appPort);
		//tracer.activeSpan().setTag("ip", consulHost);
		 return servicio.LibroByID(id);
	}
	
	
	@POST
	@Transactional
	public Libro createLibro(Libro libro) {
		//tracer.activeSpan().setTag("puerto", appPort);
		//	tracer.activeSpan().setTag("ip", consulHost);
		return servicio.crearLibro(libro);
		
	}
	
	@PUT
	@Transactional
	public Libro update(Libro libro) {
		//	tracer.activeSpan().setTag("puerto", appPort);
		//	tracer.activeSpan().setTag("ip", consulHost);
		return servicio.actualizar(libro);
		
	}

	@DELETE
	@Transactional
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		//	tracer.activeSpan().setTag("puerto", appPort);
		//tracer.activeSpan().setTag("ip", consulHost);
		return servicio.eliminar(id);
		
	}
	
}
