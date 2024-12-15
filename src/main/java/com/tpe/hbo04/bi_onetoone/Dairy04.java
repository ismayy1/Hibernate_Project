package com.tpe.hbo04.bi_onetoone;

import javax.persistence.*;

@Entity
public class Dairy04 {

    @Id
    private int id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "std_id")
    private Student04 student;

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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Dairy04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
