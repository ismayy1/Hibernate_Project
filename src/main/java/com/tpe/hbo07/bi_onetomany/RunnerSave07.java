package com.tpe.hbo07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 student1 = new Student07();
        student1.setId(1001);
        student1.setName("Ceylan");
        student1.setGrade(88);

        Student07 student2 = new Student07();
        student2.setId(1002);
        student2.setName("Ali");
        student2.setGrade(99);

        Student07 student3 = new Student07();
        student3.setId(1003);
        student3.setName("Bob");
        student3.setGrade(77);

        Student07 student4 = new Student07();
        student4.setId(1004);
        student4.setName("Mike");
        student4.setGrade(66);

        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Ceylan's Art Book");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("Ceylan's Math Book");

        Book07 book3 = new Book07();
        book3.setId(103);
        book3.setName("Ali's Java Book");

        Book07 book4 = new Book07();
        book4.setId(104);
        book4.setName("Ali's Hibernate Book");

        Book07 book5 = new Book07();
        book5.setId(105);
        book5.setName("Bob's JS Book");

        Book07 book6 = new Book07();
        book6.setId(106);
        book6.setName("A normal book");

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);




        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        session.save(book6);



        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
