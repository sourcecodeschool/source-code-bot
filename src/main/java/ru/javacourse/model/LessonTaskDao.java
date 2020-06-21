package ru.javacourse.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javacourse.config.HibernateConfig;

import java.util.List;

public class LessonTaskDao {
    private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    //получение списка всех записей таблицы
    public List<LessonTask> getAll(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<LessonTask> lessonTasks = session.createQuery("from lesson_task").list();
        tx.commit();
        session.close();
        return  lessonTasks;
    }
    //получение записи по id
    public LessonTask getById(String ltId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        LessonTask lessonTask = session.get(LessonTask.class, ltId);
        tx.commit();
        session.close();
        return lessonTask;
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
    public <T> void delete (T entity){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    //обновление записи по id
    public <T> void saveOrUpdate(T entity)
    {
        Session session = sessionFactory.openSession();
        Transaction tx =session.beginTransaction();
        session.saveOrUpdate(entity);
        tx.commit();
        session.close();
    }
}
