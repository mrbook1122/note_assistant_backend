package com.mrbook.mapper;

import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;

import java.util.List;

public interface NotebookMapper {
    //新建一个笔记本
    void save(Notebook notebook);

    //删除一个笔记本（此方法会从数据库中彻底删除这条记录，
    //如果只是暂时删除，则更改笔记本的状态，调用update方法
    void delete(Notebook notebook);

    //获取用户的所有笔记本列表（包括状态为0和1的）
    List<Notebook> getAllNotebooksByUser(User user);

    //获取用户未删除的笔记本列表
    List<Notebook> getNotebooksByUser(User user);

    //获取用户删除的笔记本列表
    List<Notebook> getDeleteNotebooksByUser(User user);

    //更新一个笔记本的信息
    void update(Notebook notebook);
}
