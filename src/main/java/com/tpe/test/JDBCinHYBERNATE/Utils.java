package com.tpe.test.JDBCinHYBERNATE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Utils {
    Configuration configuration = new Configuration()
            .configure("hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

// First example of group project - registerStudent() ======================
//    Connection connection;
//    Statement statement;
//
//    {
//        try {
//            connection = DriverManager.getConnection("hibernate.cfg.xml");
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void registerStudent(Student student) throws SQLException {
//
//        String hql = "INSERT INTO Student(id, name, grade) VALUES (?, ?, ?)";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(hql);
//        preparedStatement.setInt(1, student.getId());
//        preparedStatement.setString(2, student.getName());
//        preparedStatement.setInt(3, student.getGrade());
//
//        System.out.println(student);
//    }
}
