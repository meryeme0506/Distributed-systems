package com.tp.miage.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "student")
@Data
public class Student{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;


}



