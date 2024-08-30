package com.crud.demo_crud.services;

import java.util.List;

import com.crud.demo_crud.entity.Person;

public interface PersonService {
    //En esta interfaz se definen los métodos que se van a implementar en la clase PersonServiceImpl
    //Estos métodos son los que se van a utilizar en el controlador
    //Buscar todos los registros
    public List<Person> findAll();
    //Buscar por id
    public Person findById(Long id);
    //Guardar un registro
    public Person save(Person person);
    //Eliminar un registro
    public void delete(Person person);
} 
