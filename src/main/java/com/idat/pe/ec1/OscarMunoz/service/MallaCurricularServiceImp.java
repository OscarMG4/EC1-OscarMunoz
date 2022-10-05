package com.idat.pe.ec1.OscarMunoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.model.MallaCurricular;
import com.idat.pe.ec1.OscarMunoz.repository.MallaCurricularRepository;

public class MallaCurricularServiceImp implements MallaCurricularService {
	
	@Autowired
	private MallaCurricularRepository repository;
	
	@Override
	public void guardar(MallaCurricular malla) {
		repository.save(malla);

	}

	@Override
	public void actualizar(MallaCurricular malla) {
		repository.saveAndFlush(malla);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<MallaCurricular> listar() {
		return repository.findAll();
	}

	@Override
	public MallaCurricular obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
