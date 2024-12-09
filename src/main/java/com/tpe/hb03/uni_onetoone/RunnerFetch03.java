package com.tpe.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Dairy.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



//        TASK: Use the get() to fetch the student with the ID 1001
        Student03 student1 = session.get(Student03.class, 1001);

//        TASK: Use the get() to fetch the dairy with the ID 101
        Dairy dairy1 = session.get(Dairy.class, 101);



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
