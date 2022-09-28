package com.tp.miage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "book_id")
    private Integer id;
    @Column(name="code")
    private String code;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="student_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Student student;
}
