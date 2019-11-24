package com.mrbook.model.dto;

import com.mrbook.model.entity.Notebook;
import lombok.Data;

@Data
public class NotebookResp {
    private int code;
    private String msg;
    private Notebook notebook;
}
