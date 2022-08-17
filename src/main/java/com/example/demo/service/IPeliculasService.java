package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Peliculas;

public interface IPeliculasService {

	public List<Peliculas> listarPeliculas(); //Listar All 
	
	public Peliculas guardarPelicula(Peliculas pelicula);	//Guarda un video CREATE
	
	public Peliculas peliculaXID(Long id); //Leer datos de un video READ
	
	public Peliculas actualizarPelicula(Peliculas pelicula); //Actualiza datos del video UPDATE
	
	public void eliminarPelicula(Long id);// Elimina el video DELETE
}
