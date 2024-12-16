package com.tpe.hbo11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students11.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("************** First Get Method --> For Student #1 **************");
        Students11 students1 = session.get(Students11.class, 1);

        session.clear();    // clears our sessionCache (First Level Cache)

        System.out.println("************** Second Get Method --> For Student #1 **************");
        Students11 students2 = session.get(Students11.class, 1);


        transaction.commit();
        session.close();    // First level cache dies
        sessionFactory.close(); // We cannot create sessions anymore from this sessionFactory
    }
}
