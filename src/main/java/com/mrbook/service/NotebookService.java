package com.mrbook.service;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NotebookParam;
import com.mrbook.model.entity.Notebook;

import java.util.List;

public interface NotebookService {
    List<Notebook> getAllNotebooks();

    Notebook saveNotebook(NotebookParam notebookParam);

    CommonResult deleteNotebook(int id);
}
