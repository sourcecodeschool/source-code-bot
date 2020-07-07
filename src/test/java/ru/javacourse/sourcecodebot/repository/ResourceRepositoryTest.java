package ru.javacourse.sourcecodebot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.javacourse.sourcecodebot.model.Resource;

import java.util.List;

@SpringBootTest
public class ResourceRepositoryTest {

    @Autowired
    private ResourceRepository repository;

    @Test
    public void testFind() {
        List<Resource> resources = repository.findAll();
        Assertions.assertNotEquals(0, resources.size());
    }
}
