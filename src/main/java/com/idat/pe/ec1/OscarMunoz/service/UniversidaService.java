package com.idat.pe.ec1.OscarMunoz.service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.model.Universidad;

public interface UniversidaService {
	
	void guardar(Universidad universidad);

	void actualizar(Universidad universidad);

	void eliminar(Integer id);

	List<Universidad> listar();

	Universidad obtener(Integer id);
	
}
