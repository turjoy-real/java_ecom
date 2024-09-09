package org.turjoysaha.ecom.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Book> books;

    public Author() {}

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
}
