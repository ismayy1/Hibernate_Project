package com.tpe.hbo07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        TASK:
//        Student07 student1 = session.get(Student07.class, 1001);
//        student1.getBookList().forEach(System.out::println);

//        TASK: fetch the names students who have a book, and also the names of the books
//        String hql1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id = b.student.id";
//        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
//
//        resultList1.forEach(oa -> System.out.println(Arrays.toString(oa)));


//        TASK: HQL -> Delete all books from the table
//        String hql2 = "DELETE FROM Book07";
//        int updatedRow1 = session.createQuery(hql2).executeUpdate();
//
//        System.out.println("Affected row count: " + updatedRow1);

//        TASK: HQL -> Delete all books from the table
//        String hql3 = "DELETE FROM Student07";
//        int updatedRow2 = session.createQuery(hql3).executeUpdate();
//
//        System.out.println("Affected row count: " + updatedRow2);

//        TASK: Delete students that has no books
//        String hql4 = "DELETE FROM Student07 s WHERE s.id = 1004";
//        int updatedRow3 = session.createQuery(hql4).executeUpdate();
//
//        System.out.println("Affected row count: " + updatedRow3);

//        TASK:
//        Student07 student2 = session.get(Student07.class, 1001);
//        session.delete(student2);

//        TASK:
        Student07 student3 = session.get(Student07.class, 1003);
        session.delete(student3);



        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
