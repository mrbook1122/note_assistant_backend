package com.mrbook.controller;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NotebookParam;
import com.mrbook.model.entity.Notebook;
import com.mrbook.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotebookController {
    @Autowired
    private NotebookService notebookService;

    @RequestMapping("/notebook/list")
    public List<Notebook> notebookList() {
        return notebookService.getAllNotebooks();
    }

    @RequestMapping("/notebook/add")
    public Notebook addNotebook(@RequestBody NotebookParam notebookParam) {
        return notebookService.saveNotebook(notebookParam);
    }

    @DeleteMapping("/notebook/delete")
    public CommonResult deleteNotebook(@RequestBody NotebookParam notebookParam) {
        return notebookService.deleteNotebook(notebookParam.getId());
    }
}
