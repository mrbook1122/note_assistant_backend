package com.mrbook.repository;

import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.User;
import org.springframework.data.repository.Repository;

public interface NoteRepository extends Repository<Note, Integer> {
    Note getByUserAndUrl(User user, String url);

    Note save(Note note);

}
