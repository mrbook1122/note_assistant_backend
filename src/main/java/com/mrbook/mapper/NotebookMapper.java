package com.mrbook.mapper;

import com.mrbook.model.entity.Notebook;

public interface NotebookMapper {
    int save(Notebook notebook);
    Notebook getById(int id);
}
