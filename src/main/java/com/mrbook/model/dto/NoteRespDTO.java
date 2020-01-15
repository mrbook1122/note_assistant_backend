package com.mrbook.model.dto;

import com.mrbook.model.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 返回笔记列表时的dto
 *
 * @author Mrbook
 * created at 2020/1/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteRespDTO {
    private int id;
    private Date createTime;
    private Date updateTime;
    private String title;
    private String url;
    private String content;

    public static NoteRespDTO convertFromEntity(Note note) {
        NoteRespDTO dto = new NoteRespDTO();
        BeanUtils.copyProperties(note, dto);
        return dto;
    }
}
