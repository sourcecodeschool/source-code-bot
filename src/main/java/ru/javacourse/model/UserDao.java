package ru.javacourse.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javacourse.config.HibernateConfig;

import java.util.List;

public class UserDao {
    private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    //получение списка всех пользователей
    public List<User> getAll(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> users = session.createQuery("from users").list();
        tx.commit();
        session.close();
        return  users;
    }
    //получение записи по id
    public User getById(String UserId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, UserId);
        tx.commit();
        session.close();
        return user;
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
