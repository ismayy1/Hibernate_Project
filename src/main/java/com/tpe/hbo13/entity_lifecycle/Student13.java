package com.tpe.hbo13.entity_lifecycle;

import javax.persistence.*;
// Entity State:
// 1) Transient: The object is in its newly created state, with no relation to the database.
// In this state, the object has not been saved to a Hibernate session yet, and there is no corresponding entry in the database.
// A transient object will be discarded when the session is closed.

// 2) Persistent or Managed: The object has a corresponding row in the database, and operations like save(), get(), etc., have been performed.
// In this state, the object is saved to a Hibernate session, and there is a corresponding entry in the database.
// A persisted object remains in the database even if the session is closed and can be used later.

// 3) Detached: The object has been detached from a Hibernate session.
// It is no longer managed by the session, but it still has a corresponding entry in the database.
// A detached object can be re-attached to another session for further use.

// 4) Removed: The object is in the state when it is removed (via the remove() method).

@Entity
public class Student13 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int grade;

    public Long getId() {
        return id;
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
        return "Student13{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
