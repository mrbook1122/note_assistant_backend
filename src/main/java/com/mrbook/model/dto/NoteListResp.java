package com.mrbook.model.dto;

import com.mrbook.model.entity.Note;
import lombok.Data;

import java.util.List;

@Data
public class NoteListResp {
    private int code;
    private String msg;
    private List<Note> notes;
}
