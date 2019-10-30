package com.mrbook.mapper;

import com.mrbook.model.entity.Notebook;

import java.util.List;

public interface NotebookMapper {
    //新建一个笔记本
    int save(Notebook notebook);
    //删除一个笔记本
    void delete(Notebook notebook);
    //获取用户的笔记本列表
    List<Notebook> getNotebooksByUserId(int id);
    //更新一个笔记本的信息
    void update(Notebook notebook);
}
