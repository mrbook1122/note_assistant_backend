package com.mrbook.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NotebookParam {
    private int id;
    @NotBlank
    private String name;
}
