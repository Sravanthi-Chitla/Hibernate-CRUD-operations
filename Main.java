package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        // Hibernate setup
        Configuration config = new Configuration();
        config.addAnnotatedClass(Student.class);
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        // CREATE
        createStudent(factory, 5, "peter", 98);

        // READ
        readStudent(factory, 4);

        // UPDATE
        updateStudent(factory, 4, "Sita Devi", 98);

        // DELETE
        deleteStudent(factory, 4);

        factory.close();
    }

    // CREATE
    public static void createStudent(SessionFactory factory, int id, String name, int marks) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setS_id(id);
        student.setS_name(name);
        student.setS_marks(marks);

        session.persist(student);
        tx.commit();
        session.close();

        System.out.println("✅ Student created: " + student.getS_name());
    }

    // READ
    public static void readStudent(SessionFactory factory, int id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);
        session.close();

        if (student != null) {
            System.out.println("📖 Student details:");
            System.out.println("ID: " + student.getS_id());
            System.out.println("Name: " + student.getS_name());
            System.out.println("Marks: " + student.getS_marks());
        } else {
            System.out.println("⚠️ Student not found with ID " + id);
        }
    }

    // UPDATE
    public static void updateStudent(SessionFactory factory, int id, String newName, int newMarks) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            student.setS_name(newName);
            student.setS_marks(newMarks);
            session.merge(student);
            tx.commit();
            System.out.println("✏️ Student updated: " + student.getS_name());
        } else {
            System.out.println("⚠️ Student not found with ID " + id);
        }

        session.close();
    }

    // DELETE
    public static void deleteStudent(SessionFactory factory, int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
            tx.commit();
            System.out.println("🗑 Student deleted with ID " + id);
        } else {
            System.out.println("⚠️ Student not found with ID " + id);
        }

        session.close();
    }
}
