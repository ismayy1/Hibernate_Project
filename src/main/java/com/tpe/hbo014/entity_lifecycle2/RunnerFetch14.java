package com.tpe.hbo014.entity_lifecycle2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch14 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("==========> call on session.get()");
        Employee employee1 = session.get(Employee.class, 1L);

        System.out.println("==========> call on session.delete()");
        session.delete(employee1);



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
