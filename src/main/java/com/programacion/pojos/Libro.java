package com.programacion.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQuery;


@Entity
@NamedQuery(name = "Libro.findAll", query = "SELECT b FROM Libro b ORDER BY b.id")
@NamedQuery(name = "Libro.findbyAutor", query = "SELECT b FROM Libro b WHERE b.autor_id = :autor_id")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	//Al enviar a consultar a la base de datos se debe enviar la entidad a ser mapeada
	//no el atribuito
	@Column(name="autor_id")
	@Transient
    public Autor Autor;
	private Long autor_id;

	public Autor getAutor() {
		return Autor;
	}
	public void setAutor(Autor autor) {
		Autor = autor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getAutor_id() {
		return autor_id;
	}
	public void setAutor_id(Long autor_id) {
		this.autor_id = autor_id;
	}
	
	
	
}
