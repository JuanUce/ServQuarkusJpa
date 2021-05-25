package com.programacion.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.programacion.pojos.Libro;
import com.programacion.rest.AutoresRest;


@ApplicationScoped
public class ServicioLibroImpl implements ServicioLibro {

	@Inject
	EntityManager em;
	
	
	@Inject
	@RestClient
	AutoresRest rest;
	
	
	public Libro LibroByID(Long id) {
		System.out.println("Seleccionar por Libro");
		Libro lib = em.find(Libro.class,id);	
		if (lib == null) {
			throw new WebApplicationException("Libro con id=" + id + " No existe", 404);
		}
		lib.setAutor(rest.GetAutor(lib.getAutor_id()));
		return lib;	
	}
	
	
	public List<Libro> listarLibros(){
		System.out.println("Listar Libros");
		//List<Libro>libros=em.createNamedQuery("Libro.findAll",Libro.class).getResultList();
		// List<Libro> listaAux = new ArrayList<>();
		 
		 //for (Libro libs : libros) {

				//libs.setAutor(rest.GetAutor(libs.getAutor_id()));
				//listaAux.add(libs);
			//}
		 
		 
		 return em.createNamedQuery("Libro.findAll",Libro.class).getResultList();		
	}
	
	
	public List<Libro> listarbyAuthor(Long autor_id){
		System.out.println("Listar libros por autor");
		//List<Libro> libs= em.createNamedQuery("Libro.findbyAutor", Libro.class).setParameter("autor_id",autor_id).getResultList();	
	//	List<Libro> listaAux = new ArrayList<>();
		//for (Libro libros : libs) {
		//	libros.setAutor_id(rest.GetAutor(autor_id).getId());
			//System.out.println("Asignación de Direcciones");
			//listaAux.add(libros);
	//	}
		
		return em.createNamedQuery("Libro.findbyAutor", Libro.class).setParameter("autor_id",autor_id).getResultList();	
	}
	
	
	public Libro crearLibro(Libro libro) {
		System.out.println("Crear un Libro");
		if (libro.getTitle() == null) {
			
			throw new WebApplicationException("Autor con id=" + libro.getId() + " No existe", 404);	
		} else {
			em.persist(libro);
			return libro;
		}
		
	}
	
	public Libro actualizar(Libro libro) {
		System.out.println("Actualizar un Libro");
	       if (libro.getId()== null) {
	            throw new WebApplicationException("Cliente no en enviado", 422);
	        }
	       Libro entity = em.find(Libro.class,libro.getId());
	        if (entity == null) {
	            throw new WebApplicationException("Autor con id " + libro.getId() + " no existe", 404);
	        }
	        entity.setTitle(libro.getTitle());;
	        entity.setIsbn(libro.getIsbn());;
	        entity.setAutor_id(libro.getAutor_id());
	        return entity;		
		
	}

	public Response eliminar(Long id) {
		System.out.println("Eliminar un Libro");
		Libro libro = em.find(Libro.class,id);
		if (libro == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("No se pudo eliminar Autor").build();
		} else {
			em.remove(libro);
			return Response.ok(libro).status(201).build();

		}	
		
	}


}
