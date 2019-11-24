package com.mrbook.service;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.dto.NoteParam;
import com.mrbook.model.entity.Note;

import java.util.List;

public interface NoteService {
    Note saveNote(NoteParam noteParam);

    CommonResult updateNote(NoteParam noteParam);

    CommonResult updateNoteTitle(NoteParam noteParam);

    CommonResult updateNoteContent(NoteParam noteParam);

    Note getNoteById(int id);

    List<Note> getNoteByNotebookId(int id);
}
