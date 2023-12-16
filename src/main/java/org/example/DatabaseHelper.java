package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class DatabaseHelper {

    public static void insertData(List<Course> courses, Connector connector) {
        Session session = connector.getSession();
        session.beginTransaction();
        for (Course item:courses) {
            session.save(item);
        }
        session.getTransaction().commit();
        session.close();
        System.out.println("Данные добавлены в таблицу");
    }

    public static void selectData(Connector connector) {
        try(Session session = connector.getSession();) {
            List<Course> coursesList = session.createQuery("FROM Courses ", Course.class).getResultList();
            coursesList.forEach(System.out::println);
            session.close();
        }
    }

    public static void  updateData(Connector connector, int valuePrimaryKey,
                                   String newTitle, String newDuration) {

        try(Session session = connector.getSession()) {
            String hql = "FROM Courses WHERE id = :id";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("id", valuePrimaryKey);
            Course course = query.getSingleResult();
            course.setTitleCourse(newTitle);
            course.setDurationCourse(newDuration);
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteData(Connector connector) {
        try(Session session = connector.getSession()) {
            session.beginTransaction();
            List<Course> coursesList = session.createQuery("FROM Courses ", Course.class).getResultList();
            coursesList.forEach(session::delete);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
