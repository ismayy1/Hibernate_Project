package com.tpe.hbo11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {

        Students11 students1 = new Students11();
        students1.setName("Martin");
        students1.setGrade(90);

        Students11 students2 = new Students11();
        students2.setName("Kemal");
        students2.setGrade(90);

        Students11 students3 = new Students11();
        students3.setName("Ismail");
        students3.setGrade(90);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students11.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(students1);
        session.save(students2);
        session.save(students3);


        transaction.commit();
        session.close();    // First level cache dies
        sessionFactory.close(); // We cannot create sessions anymore from this sessionFactory
    }
}
