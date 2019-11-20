package com.mrbook.model.dto;

import lombok.Data;

@Data
public class NoteParam {
    private int id;
    private String title;
    private String content;
    private int notebookID;
}
