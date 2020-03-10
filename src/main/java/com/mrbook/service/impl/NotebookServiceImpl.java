package com.mrbook.service.impl;

import com.mrbook.mapper.NoteMapper;
import com.mrbook.mapper.NotebookMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.*;
import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import com.mrbook.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookMapper notebookMapper;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<NotebookDTO> getAllNotebooks() {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Notebook> notebooks = notebookMapper.getNotebooksByUsername(name);
        List<NotebookDTO> result = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            result.add(NotebookDTO.convertFromEntity(notebook));
        }
        return result;
    }

    @Override
    @Transactional
    public CommonDataDTO<Integer> saveNotebook(NotebookDTO notebookDTO) {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userMapper.getUserByName(name);
        Notebook notebook = new Notebook(notebookDTO.getName(), user.getId());
        notebookMapper.save(notebook);
        return new CommonDataDTO<>(ResultCode.SUCCESS, "添加成功", notebook.getId());
    }

    @Override
    @Transactional
    public CommonDTO deleteNotebook(int id) {
        Notebook notebook = notebookMapper.getNotebookById(id);
        notebook.setStatus(0);
        notebookMapper.update(notebook);
        return new CommonDTO(ResultCode.SUCCESS, "删除成功");
    }

    @Override
    public List<NoteRespDTO> getNotesByNotebook(int notebookId) {
        List<Note> notes = noteMapper.getNotesByNotebookId(notebookId);
        List<NoteRespDTO> result = new ArrayList<>();
        for (Note note : notes) {
            result.add(NoteRespDTO.convertFromEntity(note));
        }
        return result;
    }

    @Override
    public CommonDTO updateNotebookName(int id, String name) {
        /**
         * TODO
         * 对于传入的新的笔记本名称，需要先判断是否有重复的笔记本名称，
         * 如果不判断直接插入可能会报java.sql.SQLIntegrityConstraintViolationException异常
         * 判断的话需要查询两次数据库，可能存在性能浪费
         */
        notebookMapper.updateNotebookName(id, name);
        return new CommonDTO(ResultCode.SUCCESS, "更新成功");
    }
}
