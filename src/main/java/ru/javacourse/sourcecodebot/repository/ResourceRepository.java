package ru.javacourse.sourcecodebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javacourse.sourcecodebot.model.Resource;

public interface ResourceRepository
        extends JpaRepository<Resource, Integer> {
}
