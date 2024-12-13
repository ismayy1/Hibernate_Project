package com.tpe.hbo10.idGeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 = new Student10();
//        student1.setId(1001); // IDs are generated automatically
        student1.setName("Bob");
        student1.setGrade(99);

        Student10 student2 = new Student10();
//        student1000.setId(10001); // IDs are generated automatically
        student2.setName("Mike");
        student2.setGrade(68);


        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student10.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        sf.close();
    }
}
