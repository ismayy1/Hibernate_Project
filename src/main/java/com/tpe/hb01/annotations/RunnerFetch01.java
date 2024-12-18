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


//        3 ways to fetch the data from the DB. Predefined one is methods -> HQL (middle) -> SQL (least)
//            1. using get()
        Student01 student1 = session.get(Student01.class, 1001);
        System.out.println("student1 = " + student1);

        Student01 student2 = session.get(Student01.class, 1002);
        System.out.println("student2 = " + student2);

//            2. SQL query
        /*
        String sqlQuery1 = "SELECT * FROM t_student01";
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();

        for (Object[] objects: resultList1) {
            System.out.println(Arrays.toString(objects));
        }
        */

//            3. HQL query (Hibernate Query Language)
        /*
        String hqlQuery1 = "FROM Student01";    // we use the actual name of the class, and NOT the name we changed
        List<Student01> students = session.createQuery(hqlQuery1, Student01.class).getResultList();

        for (Student01 student01: students) {
            System.out.println(student01);
        }
        */


//        Exercises
//        1. SQL
        String sqlQuery2 = "SELECT * FROM t_student01 WHERE std_name = 'Bob Smith'";
        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();

        System.out.println(Arrays.toString(uniqueResult1));


//        2. HQL
        String hqlQuery2 = "FROM Student01 WHERE name = 'Bob Smith'";
        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println("uniqueResult2 = " + uniqueResult2);



//        HQL -> Get students with grade 90
        String hqlQuery3 = "SELECT s.id, s.name FROM Student01 s WHERE s.grade = 90";

        List<Object[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
        // we're selecting only two fields, and if we used Student01 class in the parameter, Hibernate will not be able
        // to create the Student01 object. That's why we are working with Object[]

        for (Object[] objects: resultList3) {
            System.out.println(Arrays.toString(objects));
        }

//        List students in descending order by ID
        String hqlQuery4 = "FROM Student01 s ORDER BY s.id DESC";
        List<Student01> resultList4 = session.createQuery(hqlQuery4, Student01.class).getResultList();

        for (Student01 student: resultList4) {
            System.out.println("student = " + student);
        }



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
