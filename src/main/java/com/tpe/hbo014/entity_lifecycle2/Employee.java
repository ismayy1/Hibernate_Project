package com.tpe.hbo014.entity_lifecycle2;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private Double salary;


//    Entity LifeCycle methods
    @PrePersist
    public void onPrePersist() {
        System.out.println("*********** PrePersist gets triggered here ***********");
    }

    @PostPersist
    public void onPostPersist() {
        System.out.println("*********** PostPersist gets triggered here ***********");
    }

    @PostLoad
    public void onPostLoad() {
        System.out.println("*********** PostLoad gets triggered here ***********");
    }

    @PreRemove
    public void onPreRemove() {
        System.out.println("*********** PreRemove gets triggered here ***********");
    }

    @PostRemove
    public void onPostRemove() {
        System.out.println("*********** PostRemove gets triggered here ***********");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
