package com.mrbook.mapper;

import com.mrbook.model.entity.Notebook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookMapper {
    /**
     * 新建一个笔记本
     */
    void save(Notebook notebook);

    /**
     * 删除一个笔记本（此方法会从数据库中彻底删除这条记录，
     * 如果只是暂时删除，则更改笔记本的状态，调用update方法
     */
    void delete(Notebook notebook);

    /**
     * 获取用户的所有笔记本列表（包括状态为0和1的）
     */
    List<Notebook> getAllNotebooksByUsername(String name);

    /**
     * 获取用户未删除的笔记本列表
     */
    List<Notebook> getNotebooksByUsername(String name);

    /**
     * 获取用户已删除的笔记本列表
     */
    List<Notebook> getDeleteNotebooksByUsername(String name);

    /**
     * 更新一个笔记本的信息
     */
    void update(Notebook notebook);

    /**
     * 根据id获取笔记本
     */
    Notebook getNotebookById(int id);
}
