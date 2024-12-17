package com.tpe.hbo13.entity_lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1 = new Student13();   // Transient state
        student1.setName("Martin Smith");
        student1.setGrade(75);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student13.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1); // Persistent state

        student1.setName("Mike Olsen"); // the DB will have Mike Olsen name

        session.evict(student1);    // Detached state, the changes after this will not be saved to DB

        student1.setName("Jack Jackson");   // the DB will still have Mike Olsen

        session.update(student1);   // Back to persistent state, and DB will have Jack Jackson, it's like commit in GitHub

        session.merge(student1);    // back to persistent state


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
