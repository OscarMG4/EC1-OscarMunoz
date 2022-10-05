package com.idat.pe.ec1.OscarMunoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.model.Curso;
import com.idat.pe.ec1.OscarMunoz.repository.CursoRepository;

public class CursoServiceImp implements CursoService {
	
	@Autowired
	private CursoRepository repository;

	@Override
	public void guardar(Curso curso) {
		repository.save(curso);

	}

	@Override
	public void actualizar(Curso curso) {
		repository.saveAndFlush(curso);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<Curso> listar() {
		return repository.findAll();
	}

	@Override
	public Curso obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
