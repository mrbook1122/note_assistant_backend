package com.mrbook.model.dto;

import com.mrbook.model.entity.Notebook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotebookDTO {
    private int id;
    @NotBlank
    private String name;
    private Date updateTime;
    private Date createTime;

    /**
     * 从实体类转化为dto
     */
    public static NotebookDTO convertFromEntity(Notebook notebook) {
        return new NotebookDTO(notebook.getId(), notebook.getName(),
                notebook.getUpdateTime(), notebook.getCreateTime());
    }
}
