package ru.javacourse.sourcecodebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.javacourse.sourcecodebot.model.Resource;

public interface ResourceRepository
        extends JpaRepository<Resource, Integer> {

    @Query(value = "SELECT * FROM resource r WHERE r.resource_type = ?1 ORDER BY random() LIMIT 1", nativeQuery = true)
    Resource findRandomQuestion(String resourceType);

    @Query(value = "SELECT * FROM resource r WHERE r.resource_type = ?1 and r.tag = ?2 ORDER BY random() LIMIT 1", nativeQuery = true)
    Resource findRandomQuestionByTag(String resourceType, String tag);
}
