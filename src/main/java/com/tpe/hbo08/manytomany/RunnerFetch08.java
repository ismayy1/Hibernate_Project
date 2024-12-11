package com.tpe.hbo08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student08.class)
                .addAnnotatedClass(Book08.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student08 student1 = session.get(Student08.class, 1001);
        System.out.println(student1.getBookList());

        Book08 book1 = session.get(Book08.class, 101);
        System.out.println(book1.getStudents());


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
