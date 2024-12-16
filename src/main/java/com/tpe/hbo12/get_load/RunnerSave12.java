package com.tpe.hbo12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 student1 = new Student12();
        student1.setName("Bob");
        student1.setGrade(70);

        Student12 student2 = new Student12();
        student1.setName("Mike");
        student1.setGrade(70);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
