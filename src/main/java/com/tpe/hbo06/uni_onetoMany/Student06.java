package com.tpe.hbo06.uni_onetoMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

    @Id
    private int id;

    @Column(name = "std_name", nullable = false)
    private String name;

    private int grade;

//    "One" side of the relation
    @OneToMany
    @JoinColumn   // if @JoinColumn isn't used here, the annotation will be used as a fallback operation
//    the annotation creates a separate table with 2 columns, IDs of each table. keeps track of our relation using that table
//    However, @JoinColumn is better for One-To-Many relations, because using an extra table mans more fetch queries.
    private List<Book06> bookList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
