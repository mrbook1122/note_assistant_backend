package com.mrbook.controller;

import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.CommonDataDTO;
import com.mrbook.model.dto.NoteDTO;
import com.mrbook.model.dto.NoteRespDTO;
import com.mrbook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * 添加笔记
     */
    @PutMapping("/add")
    public CommonDataDTO<Integer> addNote(@RequestBody NoteDTO noteDTO) {
        return noteService.saveNote(noteDTO);
    }

    /**
     * 更新笔记标题
     */
    @PutMapping("/{id}/title")
    public CommonDTO updateNoteTitle(@PathVariable int id, @RequestBody String title) {
        return noteService.updateNoteTitle(id, title);
    }

    /**
     * 更新笔记内容
     */
    @PutMapping("/{id}/content")
    public CommonDTO updateNoteContent(@PathVariable int id, @RequestBody String content) {
        return noteService.updateNoteContent(id, content);
    }

//    @RequestMapping(value = "/note/delete", method = RequestMethod.DELETE)
//    public CommonResult deleteNote()

    /**
     * 获取一条笔记的详细信息
     */
    @GetMapping("/{id}")
    public NoteRespDTO noteInfo(@PathVariable int id) {
        return noteService.getNoteById(id);
    }
}
