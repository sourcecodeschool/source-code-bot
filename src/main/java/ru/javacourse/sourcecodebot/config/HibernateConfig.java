package ru.javacourse.sourcecodebot.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.javacourse.model.Resource;

public class HibernateConfig {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory(){
        if(sessionFactory!=null) return sessionFactory;

        Configuration configuration = new Configuration();
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
//        configuration.addAnnotatedClass(Lesson.class);
//        configuration.addAnnotatedClass(LessonTask.class);
        configuration.addAnnotatedClass(Resource.class);
//        configuration.addAnnotatedClass(Exercise.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
