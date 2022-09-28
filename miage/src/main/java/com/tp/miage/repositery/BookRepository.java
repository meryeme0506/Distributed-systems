package com.tp.miage.repositery;

import com.tp.miage.entity.Book;
import com.tp.miage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findAll();
    public Optional<Book> findByCode(Integer code);

}
