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

import com.idat.pe.ec1.OscarMunoz.model.MallaCurricular;
import com.idat.pe.ec1.OscarMunoz.service.MallaCurricularServiceImp;

@RestController
@RequestMapping("api/MallaCurricular")
public class MallaController {
	
	@Autowired
	private MallaCurricularServiceImp repo;
	
	@RequestMapping(path = "/listarMallasCurriculares", method = RequestMethod.GET)
    public ResponseEntity<List<MallaCurricular>> list(){
        return new ResponseEntity<List<MallaCurricular>>(repo.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<MallaCurricular> search(int id){
    	MallaCurricular productExist = repo.obtener(id);
        if (productExist != null){
            return new ResponseEntity<MallaCurricular>(repo.obtener(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/guardarMallaCurricular", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody MallaCurricular malla){
        repo.guardar(malla);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizarMallaCurricular", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody MallaCurricular malla){
        repo.actualizar(malla);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminarMallaCurricular/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id){
    	MallaCurricular productExist = repo.obtener(id);

        if (productExist != null){
            repo.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
