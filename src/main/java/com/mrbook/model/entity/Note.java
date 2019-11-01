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

    //笔记的状态信息，0表示删除，1表示正常
    private int status;

    private int notebookID;

    public Note() {
    }

    public Note(Date updateTime, Date deleteTime, String title, String content, int notebookID) {
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.title = title;
        this.content = content;
        this.notebookID = notebookID;
    }

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

    public int getNotebookID() {
        return notebookID;
    }

    public void setNotebookID(int notebookID) {
        this.notebookID = notebookID;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", notebookID=" + notebookID +
                '}';
    }
}
