package com.mrbook.model.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;


@Alias("notebook")
public class Notebook {
    private int id;
    //笔记本的状态更改时间
    private Date updateTime;
    //笔记本的状态, 0表示删除，1表示未删除
    private int status;
    private String name;
    private int userID;

    public Notebook() {
    }

    public Notebook(Date updateTime, int status, String name, int userID) {
        this.updateTime = updateTime;
        this.status = status;
        this.name = name;
        this.userID = userID;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", userID=" + userID +
                '}';
    }
}
