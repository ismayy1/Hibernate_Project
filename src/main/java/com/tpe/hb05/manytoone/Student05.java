package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name = "std_name", nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createOn;

    @ManyToOne   // we're on the many side of the application
    @JoinColumn(name = "university_id")
    private University05 university;

    @PrePersist // Before persisting the data, we need some operations to be done
    public void prePersist() {
        createOn = LocalDateTime.now();
    }

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University05 getUniversity() {
        return university;
    }

    public void setUniversity(University05 university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
