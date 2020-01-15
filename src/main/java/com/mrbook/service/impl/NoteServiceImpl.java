package com.mrbook.service.impl;

import com.mrbook.exception.NoteTitleAndContentNullException;
import com.mrbook.mapper.NoteMapper;
import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.*;
import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.User;
import com.mrbook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonDataDTO<Integer> saveNote(NoteDTO noteDTO) {
        // 如果笔记标题和内容都为空，则抛异常
        if ((noteDTO.getTitle() == null || noteDTO.getTitle().trim().equals("")) &&
                (noteDTO.getContent() == null || noteDTO.getContent().trim().equals(""))) {
            throw new NoteTitleAndContentNullException();
        }
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userMapper.getUserByName(name);
        Note note = noteDTO.convertToNote(user.getId());
        noteMapper.save(note);
        return new CommonDataDTO<>(ResultCode.SUCCESS, "添加成功", note.getId());
    }

    @Override
    public CommonDTO updateNoteTitle(int id, String title) {
        noteMapper.updateNoteTitle(id, title);
        return new CommonDTO(ResultCode.SUCCESS, "更新成功");
    }

    @Override
    public CommonDTO updateNoteContent(int id, String content) {
        noteMapper.updateNoteContent(id, content);
        return new CommonDTO(ResultCode.SUCCESS, "更新成功");
    }

    @Override
    public NoteRespDTO getNoteById(int id) {
        NoteRespDTO dto = NoteRespDTO.convertFromEntity(noteMapper.getNoteById(id));
        return dto;
    }

    @ExceptionHandler(NoteTitleAndContentNullException.class)
    public CommonDTO noteTitleAndContentNullException() {
        return new CommonDTO(ResultCode.REQUEST_ERROR, "笔记标题和内容为空");
    }
}
