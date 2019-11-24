package com.mrbook.model.dto;

import com.mrbook.model.entity.Note;
import lombok.Data;

@Data
public class NoteResp {
    private int code;
    private String msg;
    private Note note;
}
