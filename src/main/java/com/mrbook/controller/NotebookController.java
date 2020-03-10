package com.mrbook.controller;

import com.mrbook.model.dto.*;
import com.mrbook.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebook")
public class NotebookController {
    @Autowired
    private NotebookService notebookService;

    /**
     * 笔记本列表
     */
    @GetMapping("/list")
    public List<NotebookDTO> notebookList() {
        return notebookService.getAllNotebooks();
    }

    /**
     * 获取笔记本中的笔记列表
     */
    @GetMapping("/{id}/note/list")
    public List<NoteRespDTO> noteList(@PathVariable int id) {
        return notebookService.getNotesByNotebook(id);
    }

    /**
     * 新建一个笔记本
     */
    @PutMapping("")
    public CommonDataDTO<Integer> addNotebook(@RequestBody NotebookDTO notebookDTO) {
        return notebookService.saveNotebook(notebookDTO);
    }

    /**
     * 删除笔记本
     */
    @DeleteMapping("/{id}")
    public CommonDTO deleteNotebook(@PathVariable int id) {
        return notebookService.deleteNotebook(id);
    }

    /**
     * 更新笔记本的名称
     * @param name 笔记本的新名称
     */
    @PostMapping("/{id}")
    public CommonDTO updateNotebookName(@PathVariable int id, String name) {
        return notebookService.updateNotebookName(id, name);
    }
}
