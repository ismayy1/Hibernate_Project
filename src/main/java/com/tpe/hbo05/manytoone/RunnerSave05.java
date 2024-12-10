package com.tpe.hbo05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Student05 student1 = new Student05();
        student1.setId(1001);
        student1.setName("Mr Ismail");
        student1.setGrade(100);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Mr Martin");
        student2.setGrade(90);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Mr Kemal");
        student3.setGrade(100);

        University05 university = new University05();
        university.setId(1);
        university.setName("Stanford");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University05.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(university);
        session.save(student1);
        session.save(student2);
        session.save(student3);


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
