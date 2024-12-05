package com.tpe.hb01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Classes marked with @Entity annotation correspond to table in the DB
@Table(name = "t_student01")    // if we want to change the default table name, we use @Table annotation
public class Student01 {    // Default table name = lowercase class name -> student01

    @Id     // primary key
//    @Column(name = "std_id") // to change the name of the column
    private int id;


    private String name;

    private int grade;
}
