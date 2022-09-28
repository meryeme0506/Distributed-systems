package com.tp.miage.api;

import com.tp.miage.entity.Student;
import com.tp.miage.repositery.StudentRepositery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("students")
public class StudentAPI {
    private final StudentRepositery studentRepositery;

    @GetMapping("/students1")
    public List<Student> getAll(){
        return studentRepositery.findAll();
    }

    public Optional<Student> getByEmail(String mail){
        return studentRepositery.findByEmail(mail);
    }

    public List<Student> getStudentsOlderThanTwenty(){
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

    /**
     * updates the student e-mail
     * @param s
     * @param mail
     * @return the modified student
     */
    @PutMapping("/update")
    public Student update(@RequestBody Student s, @RequestParam String mail){
        Optional<Student> student = studentRepositery.findById(s.getId());
        student.ifPresent(value -> value.setEmail(mail));
        return studentRepositery.save(student.orElse(null));
    }

    /**
     * Updates the student's last name
     * @param mail
     * @param lastName
     * @return the modified student
     */
    @PutMapping("/students3")
    public Student update(@RequestBody String mail, @RequestParam String lastName){
        Optional<Student> student = studentRepositery.findByEmail(mail);
        student.ifPresent(value -> value.setLastName(lastName));
        return studentRepositery.save(student.orElse(null));
    }
    /**
     * increments by 1 the age of a given student
     * @param s
     * @return the modified student
     */
    @PutMapping("students")
    public Student update(@RequestBody Student s){
        Optional<Student> student = studentRepositery.findById(s.getId());
        int age = s.getAge();
        student.ifPresent(value -> value.setAge(age+1));
        return studentRepositery.save(student.orElse(null));
    }

    public void incrementingAgeByOne(){
        List<Student> students = studentRepositery.findAll();
        for(Student s : students){
            update(s);
        }
    }

    @DeleteMapping("students/email/{email}")
    public void delete(@PathVariable String mail){
        Optional<Student> student = studentRepositery.findByEmail(mail);
        studentRepositery.delete(student.orElse(null));
    }



}
