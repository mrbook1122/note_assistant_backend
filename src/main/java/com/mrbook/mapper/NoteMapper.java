package com.mrbook.mapper;

import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteMapper {
    /**
     * 保存一条笔记
     */
    void save(Note note);

    /**
     * 删除一条笔记
     */
    void delete(Note note);

    /**
     * 获取某个笔记本中的笔记列表，
     * 获取的结果只有id，updateTime，title属性，content属性为null
     */
    List<Note> getNotesByNotebookId(int id);

    /**
     * 获取用户所有被删除的笔记列表
     * 获取的结果只有id，updateTime，title属性，content属性为null
     */
    List<Note> getAllDeleteNotes(User user);

    //获取某条笔记的全部信息
    Note getNoteById(int noteId);

    /**
     * 更新笔记信息
     */
    void update(Note note);

    /**
     * 更新笔记标题
     */
    void updateNoteTitle(int id, String title);

    /**
     * 更新笔记内容
     */
    void updateNoteContent(int id, String content);
}
