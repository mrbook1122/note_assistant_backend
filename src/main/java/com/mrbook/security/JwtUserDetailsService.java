package com.mrbook.security;

import com.mrbook.model.entity.User;
//import com.mrbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
//        System.out.println("search name: " + s);
//        if (user == null)
//            throw new UsernameNotFoundException("No user found for " + s);
        return new JwtUserDetails(user.getName(), user.getPass());
    }
}
