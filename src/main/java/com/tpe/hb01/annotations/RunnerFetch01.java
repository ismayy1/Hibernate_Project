package com.tpe.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        3 ways to fetch the data from the DB
//            1. using get()
        Student01 student1 = session.get(Student01.class, 1001);
        System.out.println("student1 = " + student1);

        Student01 student2 = session.get(Student01.class, 1002);
        System.out.println("student2 = " + student2);

//            2. SQL query
        String sqlQuery1 = "SELECT * FROM t_student01";
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();

        for (Object[] objects: resultList1) {
            System.out.println(Arrays.toString(objects));
        }

//            3. HQL query (Hibernate Query Language)


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
