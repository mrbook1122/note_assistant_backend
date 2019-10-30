package com.mrbook;

import com.mrbook.mapper.UserMapper;
import com.mrbook.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(NoteApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setName("mrbook1");
//        user.setPass("pass");
//        user.setPhoneNumber("15520858522");
//        userMapper.saveUser(user);
//    }
}
