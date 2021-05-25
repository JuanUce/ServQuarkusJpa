package com.programacion.servicios;

import java.util.List;

import javax.ws.rs.core.Response;

import com.programacion.pojos.Libro;


public interface ServicioLibro {

   public List<Libro> listarLibros();
	
	public Libro LibroByID(Long id);
	 
	public List<Libro> listarbyAuthor(Long autor_id);
	//necesito consultar las direcciones Existentes
	public Libro crearLibro(Libro libro);
	//necesito consultar las direcciones Existentes
	public Libro actualizar(Libro libro);
	
	public Response eliminar(Long id);
	
	
}
