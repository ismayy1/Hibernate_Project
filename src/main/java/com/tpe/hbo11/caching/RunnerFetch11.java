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
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();


        System.out.println("************** First Get Method --> For Student #1 **************");
        Students11 students1 = session1.get(Students11.class, 1);

        session1.clear();    // clears our sessionCache (First Level Cache)

        System.out.println("************** Second Get Method --> For Student #1 **************");
        Students11 students2 = session1.get(Students11.class, 1);


        transaction1.commit();
        session1.close();    // First level cache dies

//        ===================
        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();


        System.out.println("************** After closing session1 --> For Student #1 **************");
        Students11 students3 = session2.get(Students11.class, 1);

        transaction2.commit();
        session2.close();
//        ===================

        sessionFactory.close(); // We cannot create sessions anymore from this sessionFactory
    }
}
