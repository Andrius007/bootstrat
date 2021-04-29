package com.example.bootstrat.service;


import com.example.bootstrat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Сорян, юзера %s не существует", s));
        }
        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}
