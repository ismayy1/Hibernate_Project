package com.tpe.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student1 = new Student03();
        student1.setId(1001);
        student1.setName("Bob Smith");
        student1.setGrade(10);

        Student03 student2 = new Student03();
        student2.setId(1002);
        student2.setName("Mike Olsen");
        student2.setGrade(45);

        Student03 student3 = new Student03();
        student3.setId(1003);
        student3.setName("Jack Jackson");
        student3.setGrade(60);


        Dairy dairy1 = new Dairy();
        dairy1.setId(101);
        dairy1.setName("Bob's Dairy");
        dairy1.setStudent(student1);

        Dairy dairy2 = new Dairy();
        dairy2.setId(102);
        dairy2.setName("Mike's Diary");
        dairy2.setStudent(student2);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Dairy.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(dairy1);
        session.save(dairy2);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
