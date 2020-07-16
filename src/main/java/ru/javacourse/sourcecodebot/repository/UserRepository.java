package ru.javacourse.sourcecodebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javacourse.sourcecodebot.model.User;


public interface UserRepository extends JpaRepository<User, Long> {


}
