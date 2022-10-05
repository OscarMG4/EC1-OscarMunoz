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

import com.idat.pe.ec1.OscarMunoz.model.Universidad;
import com.idat.pe.ec1.OscarMunoz.service.UniversidadServiceImp;


@RestController
@RequestMapping("api/Universidad")
public class UniversidadController {
	
	@Autowired
	private UniversidadServiceImp repo;
	
	@RequestMapping(path = "/listarUniversidades", method = RequestMethod.GET)
    public ResponseEntity<List<Universidad>> list(){
        return new ResponseEntity<List<Universidad>>(repo.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Universidad> search(int id){
    	Universidad productExist = repo.obtener(id);
        if (productExist != null){
            return new ResponseEntity<Universidad>(repo.obtener(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/guardarUniversidad", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Universidad uni){
        repo.guardar(uni);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizarUniversidad", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Universidad uni){
        repo.actualizar(uni);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminarUniversidad/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id){
    	Universidad productExist = repo.obtener(id);

        if (productExist != null){
            repo.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
