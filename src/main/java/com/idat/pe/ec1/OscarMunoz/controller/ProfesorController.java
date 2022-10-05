package com.idat.pe.ec1.OscarMunoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.ec1.OscarMunoz.model.Profesor;
import com.idat.pe.ec1.OscarMunoz.service.ProfesorServiceImp;


@RestController
@RequestMapping("api/profesor")
public class ProfesorController {
	
	@Autowired
	private ProfesorServiceImp repo;
	
	@RequestMapping(path = "/listarProfesores", method = RequestMethod.GET)
    public ResponseEntity<List<Profesor>> list(){
        return new ResponseEntity<List<Profesor>>(repo.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Profesor> search(int id){
    	Profesor productExist = repo.obtener(id);
        if (productExist != null){
            return new ResponseEntity<Profesor>(repo.obtener(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/guardarProfesor", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Profesor profesor){
        repo.guardar(profesor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizarProfesor", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Profesor profesor){
        repo.actualizar(profesor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminarProfesor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id){
    	Profesor productExist = repo.obtener(id);

        if (productExist != null){
            repo.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
