package com.ing.store.service.impl;

import com.ing.store.domain.entity.User;
import com.ing.store.exception.UsernameNotFoundException;
import com.ing.store.repository.UserRepository;
import com.ing.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(UsernameNotFoundException::new);
    }
}
