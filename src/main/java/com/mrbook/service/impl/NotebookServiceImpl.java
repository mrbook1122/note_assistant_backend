package com.mrbook.service.impl;

import com.mrbook.mapper.NoteMapper;
import com.mrbook.mapper.NotebookMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.NoteRespDTO;
import com.mrbook.model.dto.NotebookDTO;
import com.mrbook.model.dto.ResultCode;
import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.Notebook;
import com.mrbook.model.entity.User;
import com.mrbook.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public Notebook saveNotebook(NotebookDTO notebookDTO) {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userMapper.getUserByName(name);
        Notebook notebook = new Notebook();
        notebook.setStatus(1);
        notebook.setName(notebookDTO.getName());
        notebook.setUserId(user.getId());
        notebookMapper.save(notebook);
        return notebook;
    }

    @Override
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
}
