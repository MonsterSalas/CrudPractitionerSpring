package com.crud.demo_crud.entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    //Esta clase es la que se va a mapear a la tabla de la base de datos
    private static final long serialVersionUID = 1L;
    //Se definen los atributos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Se definen las restricciones de los campos
    @NotBlank
    @Column(name = "name")
    private String name;
    @Column (name = "address")
    private String address;

    @Column (name = "phone")
    private Integer phone;

    @Column (name = "created_at")
    @CreatedDate
    private Date created_at;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Integer getPhone() {
        return phone;
    }


    public void setPhone(Integer phone) {
        this.phone = phone;
    }


    public Date getCreated_at() {
        return created_at;
    }


    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }    
}
