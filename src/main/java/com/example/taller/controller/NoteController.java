package com.example.taller.controller;

import com.example.taller.entity.Note;
import com.example.taller.request.NoteRequest;
import com.example.taller.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@CrossOrigin(origins = "http://localhost:3000")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public Note createNote(@RequestBody NoteRequest noteRequest)
    {
        return noteService.createNote(noteRequest);
    }
    @GetMapping("/find/all")
    public List<Note> findAll()
    {
        return noteService.findAll();
    }
    @PutMapping("/update/{id}")
    public Note updateNote(@PathVariable long id, @RequestBody NoteRequest noteRequest)
    {
        return noteService.update(id, noteRequest);
    }
}
