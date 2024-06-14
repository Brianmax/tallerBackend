package com.example.taller.service;

import com.example.taller.entity.Note;
import com.example.taller.request.NoteRequest;

import java.util.List;

public interface NoteService {
    // agregar
    Note createNote(NoteRequest noteRequest);
    Note findById(long id);
    List<Note> findAll();
    Note update(long id, NoteRequest noteRequest);
    void deleteById(int id);
}
