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
     * 更新笔记本的名称
     */
    void updateNotebookName(int id, String name);

    /**
     * 根据id获取笔记本
     */
    Notebook getNotebookById(int id);

    /**
     * 对于传入的笔记本id的对应的笔记本名称，判断该用户是否有其他笔记本与传入的新笔记本名称重复
     *
     * @param notebookId      要修改名称的笔记本的id
     * @param newNotebookName 传入的新的笔记本名称
     * @return notebook 名称重复的笔记本对象(也可能返回本notebookId对应的对象)
     */
    Notebook getDuplicateNotebookNameNotebook(int notebookId, String newNotebookName);
}
