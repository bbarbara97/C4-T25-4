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

import com.example.demo.dto.Salas;
import com.example.demo.service.SalasServiceImpl;

@RestController
@RequestMapping("/api")
public class SalasController {

	@Autowired
	SalasServiceImpl salasServideImpl;
	
	@GetMapping("/salas")
	public List<Salas> listarSalas(){
		return salasServideImpl.listarSalas();
	}
	
	@PostMapping("/salas")
	public Salas salvarSala(@RequestBody Salas salas) {
		
		return salasServideImpl.guardarSala(salas);
	}
	
	@GetMapping("/salas/{codigo}")
	public Salas salasXID(@PathVariable(name="codigo") Long codigo) {
		
		Salas salas_xid= new Salas();
		
		salas_xid=salasServideImpl.salaXID(codigo);
		
		System.out.println("Sala XID: "+salas_xid);
		
		return salas_xid;
	}
	
	@PutMapping("/salas/{codigo}")
	public Salas actualizarSala(@PathVariable(name="codigo") Long codigo,@RequestBody Salas salas) {
		
		Salas salas_seleccionado;
		Salas salas_actualizado;
		
		salas_seleccionado= salasServideImpl.salaXID(codigo);
		
		salas_seleccionado.setNombre(salas.getNombre());
		salas_seleccionado.setPelicula(salas.getPelicula());
		
		salas_actualizado = salasServideImpl.actualizarSala(salas_seleccionado);
		
		System.out.println("La caja actualizada es: "+ salas_actualizado);
		
		return salas_actualizado;
	}
	
	@DeleteMapping("/salas/{codigo}")
	public void eleiminarArticulo(@PathVariable(name="codigo")Long codigo) {
		salasServideImpl.eliminarSala(codigo);
	}
}
