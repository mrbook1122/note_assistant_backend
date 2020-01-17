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
    @PutMapping("")
    public CommonDataDTO<Integer> addNote(@RequestBody NoteDTO noteDTO) {
        return noteService.saveNote(noteDTO);
    }

    /**
     * 更新笔记标题
     */
    @PostMapping("/{id}/title")
    public CommonDTO updateNoteTitle(@PathVariable int id, @RequestBody NoteDTO noteDTO) {
        return noteService.updateNoteTitle(id, noteDTO.getTitle());
    }

    /**
     * 更新笔记内容
     */
    @PostMapping("/{id}/content")
    public CommonDTO updateNoteContent(@PathVariable int id, @RequestBody NoteDTO noteDTO) {
        return noteService.updateNoteContent(id, noteDTO.getContent());
    }

    /**
     * 暂时删除一条笔记
     */
    @DeleteMapping(value = "/{id}")
    public CommonDTO deleteNote(@PathVariable int id) {
        return noteService.deleteNote(id);
    }

    /**
     * 获取一条笔记的详细信息
     */
    @GetMapping("/{id}")
    public NoteRespDTO noteInfo(@PathVariable int id) {
        return noteService.getNoteById(id);
    }
}
