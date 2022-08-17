package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Salas;

public interface ISalasService {

public List<Salas> listarSalas(); //Listar All 
	
	public Salas guardarSala(Salas sala);	//Guarda un video CREATE
	
	public Salas salaXID(Long codigo); //Leer datos de un video READ
	
	public Salas actualizarSala(Salas sala); //Actualiza datos del video UPDATE
	
	public void eliminarSala(Long codigo);// Elimina el video DELETE
}
