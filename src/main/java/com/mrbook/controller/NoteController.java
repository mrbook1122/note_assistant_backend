package com.mrbook.controller;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NoteParam;
import com.mrbook.model.entity.Note;
import com.mrbook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/note/add")
    public Note addNote(@RequestBody NoteParam noteParam) {
        return noteService.saveNote(noteParam);
    }

    @RequestMapping("/note/update")
    public CommonResult updateNote(NoteParam noteParam) {
        return noteService.updateNote(noteParam);
    }

    @RequestMapping("/note/list")
    public List<Note> noteList(int id) {
        return noteService.getNoteByNotebookId(id);
    }

//    @RequestMapping(value = "/note/delete", method = RequestMethod.DELETE)
//    public CommonResult deleteNote()

    @RequestMapping("/note/info")
    public Note noteInfo(int id) {
        return noteService.getNoteById(id);
    }
}
