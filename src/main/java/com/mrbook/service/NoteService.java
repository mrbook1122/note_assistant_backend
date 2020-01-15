package com.mrbook.service;

import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.CommonDataDTO;
import com.mrbook.model.dto.NoteDTO;
import com.mrbook.model.dto.NoteRespDTO;
import com.mrbook.model.entity.Note;

import java.util.List;

public interface NoteService {
    /**
     * 保存笔记
     */
    CommonDataDTO<Integer> saveNote(NoteDTO noteDTO);

    /**
     * 更新笔记标题
     */
    CommonDTO updateNoteTitle(int id, String title);

    /**
     * 更新笔记内容
     */
    CommonDTO updateNoteContent(int id, String content);

    /**
     * 获取笔记的详细信息，包括笔记内容
     */
    NoteRespDTO getNoteById(int id);
}
