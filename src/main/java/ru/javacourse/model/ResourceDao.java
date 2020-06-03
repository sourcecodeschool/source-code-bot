package ru.javacourse.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javacourse.config.HibernateConfig;

import java.util.List;

public class ResourceDao {

    private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    //получение списка всех уроков
    public List<Resource> getAll ()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List <Resource> resources = session.createQuery("from Resource").list();
        tx.commit();
        session.close();
        return resources;
    }

    //получение записи по id
    public Resource getById (String resourceId)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Resource resource = session.get(Resource.class, resourceId);
        tx.commit();
        session.close();
        return resource;

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
