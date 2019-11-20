package com.mrbook.service.impl;

import com.mrbook.mapper.NotebookMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NotebookParam;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import com.mrbook.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookMapper notebookMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Notebook> getAllNotebooks() {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();
        user.setName(name);
        return notebookMapper.getNotebooksByUser(user);
    }

    @Override
    public Notebook saveNotebook(NotebookParam notebookParam) {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userMapper.getUserByName(name);
        Notebook notebook = new Notebook(new Date(), 1, notebookParam.getName(), user.getId());
        notebookMapper.save(notebook);
        return notebook;
    }

    @Override
    public CommonResult deleteNotebook(int id) {
        Notebook notebook = notebookMapper.getNotebookById(id);
        notebook.setStatus(0);
        notebookMapper.update(notebook);
        return new CommonResult(200, "删除成功");
    }
}
