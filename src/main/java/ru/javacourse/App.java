package ru.javacourse;

import ru.javacourse.Dao.CommonDao;
import ru.javacourse.model.Resource;

public class App {
    public static void main(String[] args) {

        CommonDao dao = new CommonDao();
        Resource resource = new Resource();
        resource.setTechnology("Java");
        resource.setTag("Spring");
        resource.setTitle("Для чего используется аннотация @Bean?");
        resource.setDescription("В классах конфигурации Spring, " +
                "@Bean используется для определения компонентов с кастомной логикой");
        resource.setResourceType("interview_question");
        dao.save(resource);

        System.out.println("Hello Source Code Student!");
    }
}
