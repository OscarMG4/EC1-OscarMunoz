package com.idat.pe.ec1.OscarMunoz.service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.model.Profesor;


public interface ProfesorService {
	
	void guardar(Profesor profesor);

	void actualizar(Profesor profesor);

	void eliminar(Integer id);

	List<Profesor> listar();

	Profesor obtener(Integer id);


}
