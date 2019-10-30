package com;


import com.mrbook.NoteApplication;
import com.mrbook.config.MyBatisConfig;
import com.mrbook.mapper.NotebookMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = NoteApplication.class)
class Test {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotebookMapper notebookMapper;

    @org.junit.jupiter.api.Test
    void getAll() {
        User user = userMapper.getUserByName("mrbook");
        System.out.println(user);
        List<Notebook> notebooks = notebookMapper.getNotebooksByUserId(1);
        for (Notebook notebook : notebooks) {
            System.out.println(notebook.getName());
        }
    }

    @org.junit.jupiter.api.Test
    void insert() {
        User user = userMapper.getUserByName("mrbook");
        System.out.println(new Date());
        Notebook notebook = new Notebook(new Date(),
                1, "name1", user);
        int i = notebookMapper.save(notebook);
        System.out.println(notebook.getId());
        System.out.println(i);
    }

    @org.junit.jupiter.api.Test
    void update() {
        User user = userMapper.getUserByName("mrbook");
        user.setName("dddd");
        userMapper.update(user);
    }
}
