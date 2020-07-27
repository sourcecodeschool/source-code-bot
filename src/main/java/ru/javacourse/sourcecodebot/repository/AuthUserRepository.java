package ru.javacourse.sourcecodebot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.javacourse.sourcecodebot.model.AuthUser;

public interface AuthUserRepository extends CrudRepository<AuthUser, Long> {

    AuthUser findByUsername (String username);
}
