package com.tpe.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Bob Smith");
        student01.setGrade(90);

//        WE tell hibernate to get configurations from the specified file, and we tell it to read the Student01 class
//        as annotated class
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);
//        We talk to our database using a Session object, and we create it via a SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Some operations, some lines of code

        session.save(student01);    // INSERT INTO t_student01 (std_id, std_name, grade) VALUES (?, ?, ?)


        transaction.commit();   // if it's not closed, the changes we made won't be saved to the DB
        session.close();
        sessionFactory.close();
    }
}
