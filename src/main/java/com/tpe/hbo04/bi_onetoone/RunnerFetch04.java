package com.tpe.hbo04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Dairy04.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student04 student = session.get(Student04.class, 1001);
        System.out.println(student);

        // try getting a dairy
        Dairy04 dairy = session.get(Dairy04.class, 101);

        System.out.println("====================================================");
        System.out.println(student.getDairy());

        System.out.println("====================================================");
        System.out.println(dairy);

        System.out.println("====================================================");
        System.out.println(dairy.getStudent());


//        TASK: Use HQL - fetch names of the students and the names of their dairies, only if they have a dairy
        String hql = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Dairy04 d ON s.id = d.student";
//        String sql = "SELECT s.std_name, d.name FROM student04 s INNER JOIN FETCH dairy04 d ON s.id = d.std_id";

        List<Object[]> resultList1 = session.createQuery(hql).getResultList();

        for (Object[] oa: resultList1) {
            System.out.println(Arrays.toString(oa));
        }
        //alternative
//        resultList1.forEach(oa -> {
//            System.out.println(Arrays.toString(oa));
//        });

//        TASK: fetch all students, and if students have dairies, fetch their dairies too -> use LEFT JOIN
        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Dairy04 d ON s.id = d.student";

        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();

        for (Object[] result: resultList2) {
            System.out.println(Arrays.toString(result));
        }


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
