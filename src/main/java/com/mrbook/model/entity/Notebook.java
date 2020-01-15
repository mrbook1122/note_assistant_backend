package com.mrbook.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;


@Alias("notebook")
@Data
@NoArgsConstructor
public class Notebook {
    /**
     * 创建笔记本时使用的构造器
     *
     * @param name   笔记本名称
     * @param userId 用户id
     */
    public Notebook(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    private int id;

    /**
     * 笔记本的创建时间
     */
    private Date createTime;

    /**
     * 笔记本的状态更改时间，也表示创建时间
     */
    private Date updateTime;
    /**
     * 笔记本的删除时间
     */
    private Date deleteTime;
    /**
     * 笔记的状态信息，0表示删除，1表示未删除
     */
    private int status;
    /**
     * 笔记本的名称
     */
    private String name;

    /**
     * 用户id
     */
    private int userId;

}
