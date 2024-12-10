package com.tpe.hbo04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Dairy;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1 = new Student04();
        student1.setId(1001);
        student1.setName("Bob Smith");
        student1.setGrade(90);

        Student04 student2 = new Student04();
        student2.setId(1002);
        student2.setName("Mike Olsen");
        student2.setGrade(95);

        Student04 student3 = new Student04();
        student3.setId(1003);
        student3.setName("Arthur MOrgan");
        student3.setGrade(100);


        Dairy04 dairy1 = new Dairy04();
        dairy1.setId(101);
        dairy1.setName("Bob's Dairy");
        dairy1.setStudent(student1);

        Dairy04 dairy2 = new Dairy04();
        dairy2.setId(102);
        dairy2.setName("Mike's Dairy");
        dairy2.setStudent(student2);

        Dairy04 dairy3 = new Dairy04();
        dairy3.setId(103);
        dairy3.setName("Dairy that doesn't belong to no one");




        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Dairy04.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(dairy1);
        session.save(dairy2);
        session.save(dairy3);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
