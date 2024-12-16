package com.tpe.hbo11.caching;

import javax.persistence.*;

@Entity
public class Students11 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID's will begin with 1 and increases
    private int id; // Integer wrapper class is used bcs the default value is null, we have some safety there

    @Column(name = "std_name", nullable = false)
    private String name;

    private int grade;

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

    @Override
    public String toString() {
        return "Students11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
