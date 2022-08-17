package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISalasDAO;
import com.example.demo.dto.Salas;


@Service
public class SalasServiceImpl implements ISalasService{

	
	@Autowired
	ISalasDAO iSalasDAO;
	
	@Override
	public List<Salas> listarSalas() {
		
		return iSalasDAO.findAll();
	}

	@Override
	public Salas guardarSala(Salas sala) {
		
		return iSalasDAO.save(sala);
	}

	@Override
	public Salas salaXID(Long codigo) {
		return iSalasDAO.findById(codigo).get();

	}

	@Override
	public Salas actualizarSala(Salas sala) {
		
		return iSalasDAO.save(sala);
	}

	@Override
	public void eliminarSala(Long codigo) {
		
		iSalasDAO.deleteById(codigo);
		
	}
}
