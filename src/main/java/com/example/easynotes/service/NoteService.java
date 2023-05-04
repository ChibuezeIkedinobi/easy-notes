package com.example.easynotes.service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes(){    // Get all Notes
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {     // Create a new Note
        return noteRepository.save(note);
    }

     public Note getNotesById(Long noteId) {    // Get a Single Note
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));   // we are throwing a ResourceNotFoundException whenever a Note with the given id is not found.
     }

     public Note updateNote(Long noteId, Note noteDetails) {   // Update a Note
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

         note.setTitle(noteDetails.getTitle());
         note.setContent(noteDetails.getContent());

         return noteRepository.save(note);
     }

     public ResponseEntity<?> noteDelete(Long noteId) {
         Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

         noteRepository.delete(note);
         return ResponseEntity.ok().build();
     }
}
