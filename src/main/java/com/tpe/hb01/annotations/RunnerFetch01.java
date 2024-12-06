package com.tpe.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
