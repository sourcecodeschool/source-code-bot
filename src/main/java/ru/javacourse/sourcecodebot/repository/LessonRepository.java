package ru.javacourse.sourcecodebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javacourse.sourcecodebot.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
