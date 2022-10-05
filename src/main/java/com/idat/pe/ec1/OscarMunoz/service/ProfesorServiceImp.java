package com.idat.pe.ec1.OscarMunoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.model.Profesor;
import com.idat.pe.ec1.OscarMunoz.repository.ProfesorRepository;

public class ProfesorServiceImp implements ProfesorService {
	
	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public void guardar(Profesor profesor) {
		repository.save(profesor);

	}

	@Override
	public void actualizar(Profesor profesor) {
		repository.saveAndFlush(profesor);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<Profesor> listar() {
		return repository.findAll();
	}

	@Override
	public Profesor obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
