//package com.itclass.service;
//
//import com.itclass.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        List<User> users = new ArrayList<>();
//        users.add(new User("qwe", passwordEncoder.encode("qwe")));
//        users.add(new User("asd", passwordEncoder.encode("asd")));
//
//        User user = users.stream().filter(e -> e.getUsername().equalsIgnoreCase(s)).findAny()
//                .orElseThrow(() -> new RuntimeException());
//
//        List<SimpleGrantedAuthority> authList = new ArrayList<>();
//        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authList);
//    }
//}
