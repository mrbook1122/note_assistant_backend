package com.mrbook.service;

import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.NoteRespDTO;
import com.mrbook.model.dto.NotebookDTO;
import com.mrbook.model.entity.Notebook;

import java.util.List;

public interface NotebookService {
    /**
     * 获取用户的笔记本列表（不包括删除的）
     */
    List<NotebookDTO> getAllNotebooks();

    /**
     * 保存一篇笔记
     */
    Notebook saveNotebook(NotebookDTO notebookDTO);

    CommonDTO deleteNotebook(int id);

    /**
     * 获取笔记本中的笔记列表（不包括笔记内容）
     * @param notebookId 笔记本id
     * @return 笔记列表
     */
    List<NoteRespDTO> getNotesByNotebook(int notebookId);
}
