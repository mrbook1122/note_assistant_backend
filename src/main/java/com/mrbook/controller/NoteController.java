package com.mrbook.controller;

import com.mrbook.model.dto.NoteDTO;
import com.mrbook.model.entity.Note;
import com.mrbook.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
//    @Autowired
//    private NoteRepository noteRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/user/note")
//    public NoteDTO getNote(@RequestParam String url) {
//        String username = SecurityContextHolder.getContext()
//                .getAuthentication().getName();
//        System.out.println(username);
//        User user = userRepository.findByName(username);
//        Note note = noteRepository.getByUserAndUrl(user, url);
//        if (note != null) {
//            NoteDTO noteDTO = new NoteDTO();
//            noteDTO.setNote(note.getNote());
//            return noteDTO;
//        }
//        return null;
//    }
//
//    @PostMapping("/user/note")
//    public ResponseEntity saveNote(@RequestBody NoteDTO note) {
//        if (note.getUrl() == null) {
//            return ResponseEntity.badRequest().body("no note_url");
//        }
//        String username = SecurityContextHolder.getContext()
//                .getAuthentication().getName();
//        System.out.println(username);
//        User user = userRepository.findByName(username);
//        Note note1 = noteRepository.getByUserAndUrl(user, note.getUrl());
//        if (note1 == null) {
//            note1 = new Note();
//            note1.setUser(user);
//            note1.setUrl(note.getUrl());
//            note1.setNote(note.getNote());
//            note1 = noteRepository.save(note1);
//        } else {
//            note1.setNote(note.getNote());
//            noteRepository.save(note1);
//        }
//        return ResponseEntity.ok("save success");
//    }
}
