package ru.javacourse.sourcecodebot.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javacourse.config.HibernateConfig;
import ru.javacourse.model.Lesson;

import java.util.List;

public class CommonDao {
    private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private java.lang.Object Object;

    //получение списка
   public <T> List<T> getAll(T obj)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List <T> t = session.createQuery("from  " + obj.getClass().getSimpleName()).list();
        tx.commit();
        session.close();
        return t;
    }

    //получение записи по id
    public Lesson getById(String lessonId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Lesson lesson = session.get(Lesson.class, lessonId);
        tx.commit();
        session.close();
        return lesson;

    }

    //сохранение записи
    public <T> void save(T entity) {
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
