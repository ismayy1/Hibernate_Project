package com.tpe.hbo07.bi_onetomany;

import javax.persistence.*;

@Entity
public class Book07 {

    @Id
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Student07 student;

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

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
