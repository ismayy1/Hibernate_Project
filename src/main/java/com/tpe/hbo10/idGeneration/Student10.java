package com.tpe.hbo10.idGeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

        /*
            GenerationType.SEQUENCE ---> Used by OracleDB - PostgreSQL. Leaves the control to the developer/user. User/developer
            can set some information like the starting value, or how many ids will be cached.

            GenerationType.IDENTITY ---> Used by MySQL - MicrosoftSQL. The control is in Database hands. Database will create Ids
            according to its own structure. The most simple, and most used Generation Type.

            GenerationType.AUTO ---> Hibernate automatically finds the best strategy according to the database.

            GenerationType.TABLE --> Slowest one. Because of this, it is the least used one. Creates an extra table to generate Ids.

     */

    @Column
    private String name;

    private int grade;

    public int getId() {
        return id;
    }


//    Generation type is IDENTITY, hence we're not allowed to set the id
//    public void setId(int id) {
//        this.id = id;
//    }

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
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
