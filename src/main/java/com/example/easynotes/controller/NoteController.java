package com.example.easynotes.controller;



import com.example.easynotes.model.Note;
import com.example.easynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController  //  The @Controller annotation is used to define a controller and the @ResponseBody annotation is used to indicate that the return value of a method should be used as the response body of the request.
@RequestMapping("")   // declares that the url for all the apis in this controller will start with /api.
public class NoteController {

    @Autowired
    NoteService noteService;

    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();   // calls JpaRepository’s findAll() method to retrieve all the notes from the database and returns the entire list.
    }

    // Create a new Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {   // @RequestBody annotation is used to bind the request body with a method parameter
        return noteService.createNote(note);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public Note getNotesById(@PathVariable(value = "id") Long noteId) {   // The @PathVariable annotation is used to bind a path variable with a method parameter.
        return noteService.getNotesById(noteId);
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {
        return noteService.updateNote(noteId, noteDetails);
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        return noteService.noteDelete(noteId);
    }

}
