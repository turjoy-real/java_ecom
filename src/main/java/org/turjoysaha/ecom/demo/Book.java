package org.turjoysaha.ecom.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {}

    public Book(String bookName, Author author) {
        this.bookName = bookName;
        this.author = author;
    }
}
