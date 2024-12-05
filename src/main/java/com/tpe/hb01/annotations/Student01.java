package com.tpe.hb01.annotations;

import javax.persistence.*;

@Entity // Classes marked with @Entity annotation correspond to table in the DB
@Table(name = "t_student01")    // if we want to change the default table name, we use @Table annotation
public class Student01 {    // Default table name = lowercase class name -> student01

    @Id     // primary key
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id") // to change the name of the column
    private int id;

    @Column(name = "std_name", length = 60, nullable = false, unique = false)
    private String name;

    @Transient  // column will not be created in the DB, the field is just to be used in the code and NOT in the DB
    private int grade;
}
