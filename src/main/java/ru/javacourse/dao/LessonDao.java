package ru.javacourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javacourse.config.HibernateConfig;
import ru.javacourse.model.Lesson;

import java.util.List;

public class LessonDao {

    private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    //получение списка всех уроков
    public List<Lesson> getAll ()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List <Lesson> lessons = session.createQuery("from Lesson").list();
        tx.commit();
        session.close();
        return lessons;
    }

    //получение записи по id
    public Lesson getById (String lessonId)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Lesson lesson = session.get(Lesson.class, lessonId);
        tx.commit();
        session.close();
        return lesson;

    }

    //сохранение записи
    public <T> void save (T entity)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
    }

    //удаление записи
    public <T> void delete (T entity)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    //обновление записи по id
    public <T> void saveOrUpdate (T entity)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(entity);
        tx.commit();
        session.close();
    }
}
