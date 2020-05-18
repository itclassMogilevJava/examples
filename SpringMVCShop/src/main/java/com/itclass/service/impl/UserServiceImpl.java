package com.itclass.service.impl;

import com.itclass.domain.User;
import com.itclass.repository.UserRepository;
import com.itclass.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public boolean save(String login, String password) {
        if (findByLogin(login).isPresent()) {
            return false;
        }
        password = encoder.encode(password);
        userRepository.save(User.builder().login(login).password(password).build());
        return true;
    }

    @Override
    public boolean login(String login, String password) {
        User user = findByLogin(login).orElseThrow(()
                -> new UsernameNotFoundException("Wrong login or password"));
        return  (encoder.matches(password, user.getPassword()));
    }
}
