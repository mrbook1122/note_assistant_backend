package com.mrbook.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("note")
@Data
@NoArgsConstructor
public class Note {

    /**
     * 保存一篇笔记时使用的构造器
     *
     * @param title      笔记标题
     * @param content    笔记内容
     * @param url        笔记url
     * @param userId     用户id
     * @param notebookId 笔记本id
     */
    public Note(String title, String content, String url, int userId, int notebookId) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.userId = userId;
        this.notebookId = notebookId;
    }

    private int id;

    /**
     * 笔记的创建时间
     */
    private Date createTime;

    /**
     * 笔记的更新时间
     */
    private Date updateTime;

    /**
     * 笔记的删除时间，允许为null
     */
    private Date deleteTime;
    /**
     * 笔记标题，最大长度为50
     */
    private String title;
    /**
     * 笔记内容
     */
    private String content;

    /**
     * 笔记的状态信息，0表示删除，1表示正常
     */
    private int status;

    /**
     * 笔记对应的url
     */
    private String url;

    /**
     * 用户id
     */
    private int userId;

    private int notebookId;
}
