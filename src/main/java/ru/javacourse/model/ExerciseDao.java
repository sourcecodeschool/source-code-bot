package ru.javacourse.model;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javacourse.config.HibernateConfig;

import java.util.List;

public class ExerciseDao {
    private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    //получение списка всех уроков
public List<Exercise> getAll(){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    List<Exercise> exercises = session.createQuery("from Exercise").list();
    tx.commit();
    session.close();
    return  exercises;
}
    //получение записи по id
public Exercise getById(String exerciseId) {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    Exercise exercise = session.get(Exercise.class, exerciseId);
    tx.commit();
    session.close();
    return exercise;
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
