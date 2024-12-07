package com.tpe.hb02.embeddable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id
    private int id;

    @Column(name = "std_name", length = 50, nullable = false)
    private String name;

    private int grade;
}
