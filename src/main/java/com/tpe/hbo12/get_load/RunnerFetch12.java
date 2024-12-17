package com.tpe.hbo12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {

        /*
            get() ---> Returns real object, if there is no object returns null.
                If we are not sure if object exists, then we use get method.
                If we want to use returned object, then we use get method.

            load() ---> Returns a proxy object, a shadow of real object.
                If there is no object, throws exception.
                Can be used if we want to delete an object.
                Gets the real object only when we need it.
        */


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("*************** Get method BEGIN Execution ***************");
        Student12 student1 = session.get(Student12.class, 1L);

        System.out.println("*************** Get method END Execution ***************");

        System.out.println("Student ID: " + student1.getId());
        System.out.println("Student name: " + student1.getName());

        System.out.println("=======================================================");

        System.out.println("*************** Load method BEGIN Execution ***************");
        Student12 student2 = session.load(Student12.class, 2L);
        System.out.println("*************** Load method END Execution ***************");

        System.out.println("----> call to getId()");
        System.out.println("Student2 ID: " + student2.getId());
        System.out.println("Student2 name: " + student2.getName());




//        Using get() and load() methods with ID that don't exist in the DB
        System.out.println("************** Get Method BEGIN Execution **************");
        Student12 student3 = session.get(Student12.class, 5L);
        System.out.println("************** Get Method END Execution **************");

        if (student3 != null) {
            System.out.println("Student3 ID: " + student3.getId());
        }


        System.out.println("************** Load Method BEGIN Execution **************");
        Student12 student4 = session.load(Student12.class, 10L);
        System.out.println("************** Load Method END Execution **************");

        System.out.println("Student4 ID: " + student4.getId());
        System.out.println("Student4 name: " + student4.getName());



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
