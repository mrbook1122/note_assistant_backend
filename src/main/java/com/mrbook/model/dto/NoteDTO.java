package com.mrbook.model.dto;

import com.mrbook.model.entity.Note;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NoteDTO {
    private int id;
    private String title;
    private String content;
    private String url;
    @NotNull
    private int notebookId;

    /**
     * 转换为note实体类
     * @param userId 用户id
     * @return note
     */
    public Note convertToNote(int userId) {
        return new Note(title, content, url, userId, notebookId);
    }
}
