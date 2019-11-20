package com;

import com.mrbook.NoteApplication;
import com.mrbook.mapper.NoteMapper;
import com.mrbook.mapper.NotebookMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = NoteApplication.class)
public class NoteTest {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotebookMapper notebookMapper;

    @Test
    void save() {
        Note note = new Note();

        noteMapper.save(note);
        System.out.println(note);
    }

    @Test
    void getNoteById() {
        Note note = noteMapper.getNoteById(4);
        System.out.println(note);
    }

    @Test
    void getAllDeleteNotes() {
        User user = userMapper.getUserByName("dddd");
        List<Notebook> notebooks = notebookMapper.getNotebooksByUser(user);
        List<Note> notes = noteMapper.getNotesByNotebook(notebooks.get(0));
        System.out.println(notes.get(0).getUserID());
        System.out.println(notes);
    }
}
