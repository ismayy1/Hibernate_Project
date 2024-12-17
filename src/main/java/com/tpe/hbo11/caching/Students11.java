package com.tpe.hbo11.caching;
/*
    1)	First Level Cache:
            - This level is always used by default. Always on, there is no way to turn it off.
            - Every session has its own first level cache, and first level cache caches the data only in that session.
            - Results of queries done in a session will be stored in a session specific cache.
            - If there are repetitive queries in a session, the performance will increase, unnecessary database
            operations will be prevented.
            - Cached data gets deleted when session is closed.

    2)	Second Level Cache:
            - Off by default.
            - Session factory level caching. Can be used for multiple sessions.
            - Can be activated from hibernate.cfg.xml.

            -- we need two dependencies for the second level cache

    3)	Query Cache:
            - Used for queries.
            - Can be activated from hibernate.cfg.xml
            - Can cache queries for multiple sessions.

        Query Cache stores results of the queries, the second level cache stores entities and related data instead.
        Both cache type increases performance, however they are on different levels and designed for different scenarios.
*/

import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Student11")
//@Cache --> How do we want to cache these entities
// Region - the name is used for caching
// When a row on the DB is updated, student name change for example this updated data
// will also be cached, and once you want to read the data, it'll be read from the cache and NOT from the DB
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
