package com.pavelnazaro.interview.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryClass {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;

        try {
            System.out.println("============\n== CREATE 1000 RECORDS ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student newStudent;
            for (int i = 1; i <= 1000; i++) {
                newStudent = new Student("Student" + i, (int) (2 + Math.random()*4));
                session.save(newStudent);
            }

            session.getTransaction().commit();

//            System.out.println("============\n== CREATE ==\n============");
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Student newStudent = new Student(NEW_STUDENT, MARK_NEW_STUDENT);
//            System.out.println("Before save: " + newStudent);
//            session.save(newStudent);
//            System.out.println("After save: " + newStudent);
//            session.getTransaction().commit();
//            System.out.println("After save and commit: " + newStudent);

            System.out.println("============\n=== READ ===\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student studentFromDb = session.get(Student.class, 100L);
            System.out.println(studentFromDb);
//            session.close();

            session.getTransaction().commit();

            System.out.println("============\n== UPDATE ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            Long studentWithMark2Id = session.createQuery("SELECT s.id FROM Student s where s.mark=2", Long.class).setMaxResults(1).getSingleResult();
            System.out.println("studentWithMark2Id: " + studentWithMark2Id);
            Student studentForUpdate = session.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class)
                    .setParameter("id", studentWithMark2Id)
                    .getSingleResult();
            System.out.println("Loaded student with mark 2: " + studentForUpdate);
            studentForUpdate.setMark(5);
            System.out.println("Modified student: " + studentForUpdate);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student studentAfterUpdate = session.get(Student.class, studentForUpdate.getId());
            System.out.println("Loaded student after update: " + studentAfterUpdate);
            session.getTransaction().commit();
//
            System.out.println("============\n== DELETE ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
//            String studentName = session.createQuery("SELECT name FROM Student s where", Long.class).getSingleResult();
            session.delete(session.get(Student.class, 1L));
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student removedStudent = session.get(Student.class, 1L);
            System.out.println("Loaded student after remove: " + removedStudent);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
