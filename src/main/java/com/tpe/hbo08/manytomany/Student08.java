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

    public int getGreade() {
        return greade;
    }

    public void setGreade(int greade) {
        this.greade = greade;
    }

    public List<Book08> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book08> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", greade=" + greade +
                ", bookList=" + bookList +
                '}';
    }
}
