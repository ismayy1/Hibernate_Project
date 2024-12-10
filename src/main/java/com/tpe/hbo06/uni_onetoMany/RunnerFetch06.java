package com.tpe.hbo06.uni_onetoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student06.class)
                .addAnnotatedClass(Book06.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student06 student1 = session.get(Student06.class, 1002);
        System.out.println("student1 = " + student1);


//        TASK: HQL -> fetch the book with the ID 101
        String hql1 = "FROM Book06 b WHERE b.id = 101";
        Book06 book1 = session.createQuery(hql1, Book06.class).uniqueResult();
        System.out.println("book1 = " + book1);

        Book06 book2 = session.get(Book06.class, 101);
        System.out.println("book2 = " + book2);

//        TASK: fetch the books of student #1003
        String hql2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id = 1003";
        List<Object[]> resultList1 = session.createQuery(hql2).getResultList();

        resultList1.forEach(oa -> System.out.println(Arrays.toString(oa)));

//        TASK: use get() method to retrieve the same query
        Student06 student2 = session.get(Student06.class, 1003);

        student2.getBookList().forEach(System.out::println);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
