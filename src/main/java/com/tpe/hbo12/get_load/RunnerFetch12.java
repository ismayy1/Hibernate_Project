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



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
