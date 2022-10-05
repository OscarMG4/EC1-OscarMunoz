package com.idat.pe.ec1.OscarMunoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.model.Universidad;
import com.idat.pe.ec1.OscarMunoz.repository.UniversidadRepository;

public class UniversidadServiceImp implements UniversidaService{
	
	@Autowired
	private UniversidadRepository repository;

	@Override
	public void guardar(Universidad universidad) {
		repository.save(universidad);

	}

	@Override
	public void actualizar(Universidad universidad) {
		repository.saveAndFlush(universidad);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<Universidad> listar() {
		return repository.findAll();
	}

	@Override
	public Universidad obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
}
