package com.tpe.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Student02 student01 = new Student02();
        student01.setId(1001);
        student01.setName("John Doe");
        student01.setGrade(70);

        Address address1 = new Address();
        address1.setStreet("Apple Park Way");
        address1.setCity("Cupertino");
        address1.setCountry("US");
        address1.setZipCode("95014");

        student01.setAddress(address1);

        Student02 student02 = new Student02();
        student02.setId(1002);
        student02.setName("Jane Doe");
        student02.setGrade(75);

        Address address2 = new Address();
        address2.setStreet("Microsoft Way");
        address2.setCity("Redmond");
        address2.setCountry("US");
        address2.setZipCode("98052");

        student02.setAddress(address2);

//        open the configuration and start the transaction
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student01);
        session.save(student02);


//        Close the connection and transaction
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
