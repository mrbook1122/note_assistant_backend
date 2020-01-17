package com.mrbook.service;

import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.CommonDataDTO;
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
     * 新建一个笔记本
     * @param notebookDTO 包含笔记本名称
     * @return data部分为笔记本id
     */
    CommonDataDTO<Integer> saveNotebook(NotebookDTO notebookDTO);

    /**
     * 删除笔记本
     * @param id 笔记本id
     * @return 操作结果的状态
     */
    CommonDTO deleteNotebook(int id);

    /**
     * 获取笔记本中的笔记列表（不包括笔记内容）
     * @param notebookId 笔记本id
     * @return 笔记列表
     */
    List<NoteRespDTO> getNotesByNotebook(int notebookId);
}
