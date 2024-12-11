package com.tpe.hbo08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {

    @Id
    private int id;

    @Column(name = "std_name", nullable = false)
    private String name;

    private int greade;

    @ManyToMany
    @JoinTable(
            name = "student08_book08",
            joinColumns = {@JoinColumn(name = "std_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
//    If we customize our third table once, we don't need to customize it again anywhere
    private List<Book08> bookList = new ArrayList<>();
}
