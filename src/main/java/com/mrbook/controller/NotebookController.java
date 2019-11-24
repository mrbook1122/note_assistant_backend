package com.mrbook.controller;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NotebookListResp;
import com.mrbook.model.dto.NotebookParam;
import com.mrbook.model.dto.NotebookResp;
import com.mrbook.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotebookController {
    @Autowired
    private NotebookService notebookService;

    @RequestMapping("/notebook/list")
    public NotebookListResp notebookList() {
        NotebookListResp resp = new NotebookListResp();
        resp.setCode(200);
        resp.setNotebooks(notebookService.getAllNotebooks());
        return resp;
    }

    @RequestMapping("/notebook/add")
    public NotebookResp addNotebook(@RequestBody NotebookParam notebookParam) {
        NotebookResp resp = new NotebookResp();
        resp.setCode(200);
        resp.setNotebook(notebookService.saveNotebook(notebookParam));
        return resp;
    }

    @DeleteMapping("/notebook/delete")
    public CommonResult deleteNotebook(@RequestBody NotebookParam notebookParam) {
        return notebookService.deleteNotebook(notebookParam.getId());
    }
}
