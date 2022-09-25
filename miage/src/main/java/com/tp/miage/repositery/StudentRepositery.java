package com.tp.miage.repositery;

import com.tp.miage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepositery extends JpaRepository<Student,Integer> {

        public List<Student> findAll();
        public Optional<Student> findById(Integer id);
        public Optional<Student> findByEmail(String email);
        public List<Student> findAll(String name);
        public List<Student> findByAge(Integer age);





}
