package com.mrbook.security;

import com.mrbook.mapper.UserMapper;
import com.mrbook.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(s);
        System.out.println(user.getName());
        System.out.println(user.getPass());
        return new JwtUserDetails(user.getName(), user.getPass());
    }
}
