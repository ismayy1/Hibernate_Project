package com.tpe.hbo014.entity_lifecycle2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Martin");
        employee1.setSalary(30000.0);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("=============> call on session.save()");
        session.save(employee1);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
