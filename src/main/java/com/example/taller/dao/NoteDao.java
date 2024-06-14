package com.example.taller.dao;

import com.example.taller.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteDao extends JpaRepository<Note, Long> {
    Optional<Note> findByTitle(String title);
}
