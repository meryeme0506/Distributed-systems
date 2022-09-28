package com.tp.miage.service;

import com.tp.miage.entity.Book;
import com.tp.miage.entity.Student;
import com.tp.miage.repositery.BookRepository;
import com.tp.miage.repositery.StudentRepositery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final StudentRepositery studentRepositery;


    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Integer code){
        return bookRepository.findByCode(code);
    }

    public Book save(@RequestBody Book book){
        return bookRepository.save(book);
    }

    public Student update(@RequestBody Student s, @RequestParam List<Book> books){
        Optional<Student> student = studentRepositery.findById(s.getId());
        student.ifPresent(value -> value.setBooks(books));
        return studentRepositery.save(student.orElse(null));
    }


}
