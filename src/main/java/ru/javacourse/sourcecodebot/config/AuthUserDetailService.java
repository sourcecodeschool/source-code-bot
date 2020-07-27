package ru.javacourse.sourcecodebot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javacourse.sourcecodebot.model.AuthUser;
import ru.javacourse.sourcecodebot.repository.AuthUserRepository;

@Service
public class AuthUserDetailService implements UserDetailsService {

    @Autowired
    private AuthUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AuthUser user = repository.findByUsername(s);

        if (user != null){
            return user;
        }

        throw  new UsernameNotFoundException("No such user:" +s);
    }
}
