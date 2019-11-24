package com.mrbook.controller;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NoteListResp;
import com.mrbook.model.dto.NoteParam;
import com.mrbook.model.dto.NoteResp;
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
    public NoteResp addNote(@RequestBody NoteParam noteParam) {
        NoteResp noteResp = new NoteResp();
        noteResp.setNote(noteService.saveNote(noteParam));
        noteResp.setCode(200);
        return noteResp;
    }

    @RequestMapping("/note/update")
    public CommonResult updateNote(@RequestBody NoteParam noteParam) {
        return noteService.updateNote(noteParam);
    }

    @RequestMapping("/note/update/title")
    public CommonResult updateNoteTitle(@RequestBody NoteParam noteParam) {
        return noteService.updateNoteTitle(noteParam);
    }

    @RequestMapping("/note/update/content")
    public CommonResult updateNoteContent(@RequestBody NoteParam noteParam) {
        return noteService.updateNoteContent(noteParam);
    }

    @RequestMapping("/note/list")
    public NoteListResp noteList(int id) {
        NoteListResp resp = new NoteListResp();
        resp.setNotes(noteService.getNoteByNotebookId(id));
        resp.setCode(200);
        return resp;
    }

//    @RequestMapping(value = "/note/delete", method = RequestMethod.DELETE)
//    public CommonResult deleteNote()

    @RequestMapping("/note/info")
    public NoteResp noteInfo(int id) {
        NoteResp noteResp = new NoteResp();
        noteResp.setNote(noteService.getNoteById(id));
        noteResp.setCode(200);
        return noteResp;
    }
}
