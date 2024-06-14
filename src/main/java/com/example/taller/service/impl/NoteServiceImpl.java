package com.example.taller.service.impl;

import com.example.taller.dao.NoteDao;
import com.example.taller.entity.Note;
import com.example.taller.request.NoteRequest;
import com.example.taller.service.NoteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteDao noteDao;

    public NoteServiceImpl(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public Note createNote(NoteRequest noteRequest) {
        Optional<Note> noteOptional = noteDao.findByTitle(noteRequest.getTitle());

        if(noteOptional.isPresent())
        {
            throw new RuntimeException("Ya existe una nota con ese titulo");
        }
        Note note = new Note();
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());
        note.setDateCreated(new Date());
        return noteDao.save(note);
    }

    @Override
    public Note findById(long id) {
        return null;
    }

    @Override
    public List<Note> findAll() {
        return noteDao.findAll();
    }

    @Override
    public Note update(long id, NoteRequest noteRequest) {
        // verificamos que exista la nota
        Optional<Note> noteOptional = noteDao.findById(id);
        if(noteOptional.isPresent())
        {
            Note noteBd = noteOptional.get();
            noteBd.setContent(noteRequest.getContent());
            noteBd.setTitle(noteRequest.getTitle());
            noteBd.setDateModified(new Date());
            return noteDao.save(noteBd);
        }
        throw new RuntimeException("Nota no existe");
    }

    @Override
    public void deleteById(int id) {

    }
}
