package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="salas")
public class Salas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name="pelicula")
    private Peliculas pelicula;

	//Constructores

	public Salas() {
		
	}

	public Salas(int codigo, String nombre, Peliculas pelicula) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pelicula = pelicula;
	}

	//Getters y Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Peliculas getPelicula() {
		return pelicula;
	}

	public void setPelicula(Peliculas pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * Metodo toString
	 */
	
	@Override
	public String toString() {
		return "Salas [codigo=" + codigo + ", nombre=" + nombre + ", pelicula=" + pelicula + "]";
	}
	
}
