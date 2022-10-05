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

import com.idat.pe.ec1.OscarMunoz.model.Curso;
import com.idat.pe.ec1.OscarMunoz.service.CursoServiceImp;

@RestController
@RequestMapping("api/curso")
public class CursoController {
	
	@Autowired
	private CursoServiceImp repo;
	
	@RequestMapping(path = "/listarCursos", method = RequestMethod.GET)
    public ResponseEntity<List<Curso>> list(){
        return new ResponseEntity<List<Curso>>(repo.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Curso> search(int id){
    	Curso productExist = repo.obtener(id);
        if (productExist != null){
            return new ResponseEntity<Curso>(repo.obtener(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/guardarCurso", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Curso curso){
        repo.guardar(curso);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizarCurso", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Curso curso){
        repo.actualizar(curso);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminarCurso/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id){
    	Curso productExist = repo.obtener(id);

        if (productExist != null){
            repo.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
