package com.mrbook.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("note")
@Data
@NoArgsConstructor
public class Note {

    private int id;

    //笔记的更新时间
    private Date updateTime;

    //笔记的删除时间
    private Date deleteTime;
    //笔记标题
    private String title;
    //笔记内容
    private String content;

    //笔记的状态信息，0表示删除，1表示正常
    private int status;

    /**
     * 用户id
     */
    private int userID;

    private int notebookID;

    public Note(Date updateTime, Date deleteTime, String title, String content, int status, int userID, int notebookID) {
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.title = title;
        this.content = content;
        this.status = status;
        this.userID = userID;
        this.notebookID = notebookID;
    }
}
