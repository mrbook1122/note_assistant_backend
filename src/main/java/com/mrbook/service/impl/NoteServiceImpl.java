package com.mrbook.service.impl;

import com.mrbook.mapper.NoteMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NoteParam;
import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import com.mrbook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Note saveNote(NoteParam noteParam) {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userMapper.getUserByName(name);
        Note note = new Note(new Date(), null, noteParam.getTitle(), noteParam.getContent(),
                1, user.getId(), noteParam.getNotebookID());
        noteMapper.save(note);
        return note;
    }

    @Override
    public CommonResult updateNote(NoteParam noteParam) {
        Note note = noteMapper.getNoteById(noteParam.getId());
        note.setTitle(noteParam.getTitle());
        note.setContent(noteParam.getContent());
        noteMapper.update(note);
        return new CommonResult(200, "更新成功");
    }

    @Override
    public Note getNoteById(int id) {
        return noteMapper.getNoteById(id);
    }

    @Override
    public List<Note> getNoteByNotebookId(int id) {
        Notebook notebook = new Notebook();
        notebook.setId(id);
        return noteMapper.getNotesByNotebook(notebook);
    }
}
