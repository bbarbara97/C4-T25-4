package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Peliculas;
import com.example.demo.service.PeliculasServiceImpl;


@RestController
@RequestMapping("/api")
public class PeliculasController {

	@Autowired
	PeliculasServiceImpl peliculasServideImpl;

	@GetMapping("/peliculas")
	public List<Peliculas> listarAlmacenes(){
		return peliculasServideImpl.listarPeliculas();
	}

	@PostMapping("/peliculas")
	public Peliculas salvarPeliculas(@RequestBody Peliculas peliculas) {

		return peliculasServideImpl.guardarPelicula(peliculas);
	}

	@GetMapping("/peliculas/{codigo}")
	public Peliculas peliculasXID(@PathVariable(name="codigo") Long codigo) {

		Peliculas peliculas_xid= new Peliculas();

		peliculas_xid=peliculasServideImpl.peliculaXID(codigo);

		System.out.println("peliculas XID: "+peliculas_xid);

		return peliculas_xid;
	}

	@PutMapping("/peliculas/{codigo}")
	public Peliculas actualizarPelicula(@PathVariable(name="codigo")Long codigo,@RequestBody Peliculas peliculas) {

		Peliculas peliculas_seleccionado;
		Peliculas peliculas_actualizado;

		peliculas_seleccionado= peliculasServideImpl.peliculaXID(codigo);

		peliculas_seleccionado.setNombre(peliculas.getNombre());
		peliculas_seleccionado.setCalificacionEdad(peliculas.getCalificacionEdad());
		peliculas_seleccionado.setSalas(peliculas.getSalas());

		peliculas_actualizado = peliculasServideImpl.actualizarPelicula(peliculas_seleccionado);

		System.out.println("El peliculas actualizado es: "+ peliculas_actualizado);

		return peliculas_actualizado;
	}

	@DeleteMapping("/peliculas/{codigo}")
	public void eliminarPelicula(@PathVariable(name="codigo")Long codigo) {
		peliculasServideImpl.eliminarPelicula(codigo);
	}
}
