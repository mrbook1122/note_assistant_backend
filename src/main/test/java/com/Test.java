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
    void contextLoads() {
        User user = userMapper.getUserByName("mrbook");
        Notebook notebook = notebookMapper.getById(11);
        System.out.println(notebook.getUpdateTime());
    }

    @org.junit.jupiter.api.Test
    void insert() {
        User user = userMapper.getUserByName("mrbook");
        System.out.println(Calendar.getInstance().getTime());
        Date date = Calendar.getInstance().getTime();
        date.toInstant();
        Notebook notebook = new Notebook(Calendar.getInstance().getTime(),
                1, "name5",user);
        notebookMapper.save(notebook);
    }
}
