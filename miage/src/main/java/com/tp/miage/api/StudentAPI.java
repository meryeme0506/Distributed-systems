package com.tp.miage.api;

import com.tp.miage.entity.Student;
import com.tp.miage.repositery.StudentRepositery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class StudentAPI {
    private final StudentRepositery studentRepositery;

    @GetMapping("students")
    public List<Student> getAll(){
        return studentRepositery.findAll();
    }

    public Optional<Student> getByEmail(String email){
        return studentRepositery.findByEmail(email);
    }

    public List<Student> getStudentsOlderThan(){
        List<Student> students = studentRepositery.findAll();
        List<Student> studentsOlderThanAge = null;
        for(Student s : students){
            if(s.getAge()>20){
                studentsOlderThanAge.add(s);
            }
        }
        return studentsOlderThanAge;
    }

    @PostMapping
    public Student save(@RequestBody Student s){
        return studentRepositery.save(s);
    }

    @PutMapping("students")
    public Student update(@RequestBody Student s, @RequestParam String email){

    }




}
