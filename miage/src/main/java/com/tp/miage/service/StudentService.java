package com.tp.miage.service;

import com.tp.miage.entity.Student;
import com.tp.miage.repositery.StudentRepositery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepositery studentRepositery;

    public List<Student> getAll(){
        return studentRepositery.findAll();
    }
    public Student save(Student s){
        return studentRepositery.save(s);
    }
}
