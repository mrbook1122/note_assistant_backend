package com.mrbook.model.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("note")
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

    private Notebook notebook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
}
