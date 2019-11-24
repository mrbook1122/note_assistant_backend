package com.mrbook.model.dto;

import com.mrbook.model.entity.Notebook;
import lombok.Data;

import java.util.List;

@Data
public class NotebookListResp {
    private int code;
    private String msg = "成功";
    private List<Notebook> notebooks;
}
