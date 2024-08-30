package com.crud.demo_crud.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo_crud.dao.PersonDao;
import com.crud.demo_crud.entity.Person;

import jakarta.transaction.Transactional;

@Service
public class PersonServiceImplement implements PersonService{

    @Autowired
    private PersonDao personDao; //Se inyecta el objeto de la interfaz PersonDao    
    
    @Override
    @Transactional
    public List<Person> findAll() {
      return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional
    public Person findById(Long id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }
    
}
