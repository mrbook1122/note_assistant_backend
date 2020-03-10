package com;

import com.mrbook.NoteApplication;
import com.mrbook.mapper.NotebookMapper;
import com.mrbook.model.entity.Notebook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

/**
 * @author Mrbook
 * created at 2020/2/24
 */
// TODO 为什么需要加配置类
@SpringBootTest(classes = NoteApplication.class)
@Profile("dev")
public class MapperTest {
    @Autowired
    private NotebookMapper notebookMapper;

    @Test
    void test() {
        Notebook notebook = notebookMapper.getDuplicateNotebookNameNotebook(1, "b");
        System.out.println(notebook);
    }
}
