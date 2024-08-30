package com.crud.demo_crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo_crud.entity.Person;
@Repository
public interface PersonDao extends JpaRepository<Person, Long> {
    
}
