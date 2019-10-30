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

@SpringBootTest(classes = NoteApplication.class)
class Test {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotebookMapper notebookMapper;

    @org.junit.jupiter.api.Test
    void get() {
        User user = userMapper.getUserByName("mrbook");
        Notebook notebook = notebookMapper.getById(19);
        System.out.println(notebook.getUpdateTime());
        System.out.println(notebook.getName());
    }

    @org.junit.jupiter.api.Test
    void insert() {
        User user = userMapper.getUserByName("mrbook");
        System.out.println(new Date());
        Notebook notebook = new Notebook(new Date(),
                1, "name1",user);
        int i = notebookMapper.save(notebook);
        System.out.println(notebook.getId());
        System.out.println(i);
    }
}
