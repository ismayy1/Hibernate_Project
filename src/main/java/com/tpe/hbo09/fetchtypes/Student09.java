package com.tpe.hbo09.fetchtypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student09 {

    @Id
    private int id;

    @Column(name = "std_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student")
    private List<Book09> bookList = new ArrayList<>();
}
