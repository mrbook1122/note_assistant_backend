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

//    @GetMapping("/list")
//    public List<NotebookDTO> notebookList() {
//        NotebookListDTO resp = new NotebookListDTO();
//        resp.setCode(200);
//        resp.setNotebooks(notebookService.getAllNotebooks());
//        return resp;
//    }

    /**
     * 获取笔记本中的笔记列表
     */
    @RequestMapping("/{id}/note/list")
    public List<NoteRespDTO> noteList(@PathVariable int id) {
        return notebookService.getNotesByNotebook(id);
    }

//    @RequestMapping("/add")
//    public NotebookResp addNotebook(@RequestBody NotebookDTO notebookDTO) {
//        NotebookResp resp = new NotebookResp();
//        resp.setCode(200);
//        resp.setNotebook(notebookService.saveNotebook(notebookDTO));
//        return resp;
//    }

    @DeleteMapping("/delete")
    public CommonDTO deleteNotebook(@RequestBody NotebookDTO notebookDTO) {
        return notebookService.deleteNotebook(notebookDTO.getId());
    }
}
