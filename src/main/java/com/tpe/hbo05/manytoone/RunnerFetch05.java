package com.tpe.hbo05.manytoone;

import com.tpe.hbo04.bi_onetoone.Dairy04;
import com.tpe.hbo04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University05.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student05 student1 = session.get(Student05.class, 1001);
        System.out.println(student1.getUniversity());

//        TASK: fetch all the students of the University with id 1
        String hql1 = "FROM Student05 s WHERE s.university.id = 1";

        List<Student05> resultList1 = session.createQuery(hql1, Student05.class).getResultList();

        resultList1.forEach(System.out::println);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
