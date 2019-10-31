package com;


import com.mrbook.NoteApplication;
import com.mrbook.config.MyBatisConfig;
import com.mrbook.mapper.NotebookMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = NoteApplication.class)
class NotebookTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotebookMapper notebookMapper;

    @Test
    void save() {
        User user = userMapper.getUserByName("mrbook1");
        System.out.println(user);
        Notebook notebook =
                new Notebook(new Date(), 0, "notebook3", user.getId());
        notebookMapper.save(notebook);
        System.out.println(notebook);
    }

    @Test
    void delete() {
        User user = userMapper.getUserByName("mrbook1");
        List<Notebook> notebooks = notebookMapper.getAllNotebooksByUser(user);
        System.out.println(notebooks);
        notebookMapper.delete(notebooks.get(0));
    }

    @Test
    void get() {
        User user = userMapper.getUserByName("mrbook1");
        List<Notebook> notebooks = notebookMapper.getDeleteNotebooksByUser(user);
        System.out.println(notebooks);
    }

    @Test
    void update() {
        User user = userMapper.getUserByName("mrbook1");
        List<Notebook> notebooks = notebookMapper.getDeleteNotebooksByUser(user);
        System.out.println(notebooks);
        notebooks.get(0).setStatus(1);
        notebookMapper.update(notebooks.get(0));
    }
}
