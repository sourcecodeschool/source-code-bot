package ru.javacourse.sourcecodebot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.javacourse.sourcecodebot.model.Lesson;

import java.util.List;

@SpringBootTest
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository repository;

    @Test
    public void testFind() {
        List<Lesson> lessons = repository.findAll();
        Assertions.assertNotEquals(0, lessons.size());
    }
}
