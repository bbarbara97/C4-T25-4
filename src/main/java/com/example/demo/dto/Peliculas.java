package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="peliculas")
public class Peliculas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long codigo;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Column(name = "calificacionEdad")//no hace falta si se llama igual
	private int calificacionEdad;
	
    @OneToMany
    @JoinColumn(name="codigo")
    private List<Salas> salas;

	//Constructores
    
    public Peliculas(Long codigo, String nombre, int calificacionEdad, List<Salas> salas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.calificacionEdad = calificacionEdad;
		this.salas = salas;
	}

	public Peliculas() {

	}

	//Getters y Setters
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionEdad() {
		return calificacionEdad;
	}

	public void setCalificacionEdad(int calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salas")
	public List<Salas> getSalas() {
		return salas;
	}

	public void setSalas(List<Salas> salas) {
		this.salas = salas;
	}
	

	/**
	 * Metodo toString
	 */
	
	@Override
	public String toString() {
		return "Peliculas [codigo=" + codigo + ", nombre=" + nombre + ", calificacionEdad=" + calificacionEdad
				+ ", salas=" + salas + "]";
	}
	
}
