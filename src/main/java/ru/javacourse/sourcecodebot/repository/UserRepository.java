package ru.javacourse.sourcecodebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javacourse.sourcecodebot.model.User;

import java.time.LocalDate;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User u set u.lastActiveDate = ?1 where u.userId = ?2")
    void setUserLastActiveDate(LocalDate lastActiveDate, Long userId);
}
