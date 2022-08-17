package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeliculasDAO;
import com.example.demo.dto.Peliculas;

@Service
public class PeliculasServiceImpl implements IPeliculasService{

	@Autowired
	IPeliculasDAO iPeliculaDAO;
	
	@Override
	public List<Peliculas> listarPeliculas() {
		
		return iPeliculaDAO.findAll();
	}

	@Override
	public Peliculas guardarPelicula(Peliculas pelicula) {
		
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public Peliculas peliculaXID(Long codigo) {
		
		return iPeliculaDAO.findById(codigo).get();
	}

	@Override
	public Peliculas actualizarPelicula(Peliculas pelicula) {
		
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public void eliminarPelicula(Long codigo) {
		
		iPeliculaDAO.deleteById(codigo);
		
	}
	
}
