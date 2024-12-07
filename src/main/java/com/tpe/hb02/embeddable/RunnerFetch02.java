package com.tpe.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student02 student = session.get(Student02.class, 1001);
        System.out.println("student = " + student); // no address, toString override
        System.out.println("student.getAddress() = " + student.getAddress());


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
