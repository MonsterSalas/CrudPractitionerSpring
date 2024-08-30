package com.crud.demo_crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo_crud.entity.Person;
import com.crud.demo_crud.services.PersonService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1")
public class PersonController {

 @Autowired
 private PersonService personService;
    //Metodo para buscar todos los registros
    @GetMapping(value = "/persons")
    //Se crea un objeto de tipo ResponseEntity para retornar la respuesta
    public ResponseEntity<Object> get() {
        //Se crea un objeto de tipo Map para almacenar los mensajes de error
        Map<String, Object> map = new HashMap<String, Object>();
        //Se utiliza un bloque try-catch para manejar las excepciones
        try{
            //Se obtienen todos los registros
            List<Person> list = personService.findAll();
            //Se retorna la lista de registros
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        //En caso de que se genere una excepción se captura y se almacena en el objeto map
        catch(Exception e){
            //Se almacena el mensaje de error
            map.put("mensaje", e.getMessage());
            //Se retorna el mensaje de error
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo para buscar por id
    @GetMapping(value = "/persons/{id}")
    //Se crea un objeto de tipo ResponseEntity para retornar la respuesta
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        //Se crea un objeto de tipo Map para almacenar los mensajes de error
        Map<String, Object> map = new HashMap<String, Object>();
        //Se utiliza un bloque try-catch para manejar las excepciones
        try{
            //Se busca el registro por id
            Person person = personService.findById(id);
            //Se retorna el registro
            return new ResponseEntity<Object>(person, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("mensaje", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Metodo para eliminar un registro
    @PostMapping(value = "/persons")
    public ResponseEntity<Object> create(@RequestBody Person person) {
        //Se crea un objeto de tipo Map para almacenar los mensajes de error
        Map<String, Object> map = new HashMap<String, Object>();
        //Se utiliza un bloque try-catch para manejar las excepciones
        try{
            //Se guarda el registro
            Person personNew = personService.save(person);
            //Se retorna el registro guardado
            return new ResponseEntity<Object>(personNew, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("mensaje", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Metodo para actualizar un registro
    @PutMapping("persons/{id}")
    public ResponseEntity<Object> Update(@RequestBody Person person,@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            //Se busca el registro por id
            Person personUpdate = personService.findById(id);
            //Se actualizan los campos
            personUpdate.setName(person.getName());
            personUpdate.setAddress(person.getAddress());
            personUpdate.setPhone(person.getPhone());
            Person personNew = personService.save(personUpdate);
            return new ResponseEntity<Object>(personNew, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("mensaje", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Metodo para eliminar un registro
    @DeleteMapping("persons/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Person person = personService.findById(id);
            personService.delete(person);
            map.put("Borrado", map);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        catch(Exception e){
            map.put("mensaje", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
       
    
}