package io.swagger.api;

import io.swagger.model.Note;
import io.swagger.model.NoteInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-06T15:21:06.371293159Z[GMT]")
@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:3000")
public class NotesApiController  {

    private final List<Note> notes = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public ResponseEntity<List<Note>> listNotes() {
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody NoteInput noteInput) {
        Note newNote = new Note();
        newNote.setId(idCounter++);
        newNote.setTitle(noteInput.getTitle());
        newNote.setContent(noteInput.getContent());
        newNote.setCreatedAt(OffsetDateTime.now());
        newNote.setUpdatedAt(OffsetDateTime.now());
        notes.add(newNote);

        return ResponseEntity.status(HttpStatus.CREATED).body(newNote);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable long noteId) {
        Optional<Note> noteOptional = notes.stream().filter(note -> note.getId() == noteId).findFirst();
        if (noteOptional.isPresent()) {
            return ResponseEntity.ok(noteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{noteId}")
    public ResponseEntity<Note> updateNote(@PathVariable long noteId, @RequestBody NoteInput noteInput) {
        Optional<Note> noteOptional = notes.stream().filter(note -> note.getId() == noteId).findFirst();
        if (noteOptional.isPresent()) {
            Note noteToUpdate = noteOptional.get();
            noteToUpdate.setTitle(noteInput.getTitle());
            noteToUpdate.setContent(noteInput.getContent());
            noteToUpdate.setUpdatedAt(OffsetDateTime.now());
            return ResponseEntity.ok(noteToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable long noteId) {
        Optional<Note> noteOptional = notes.stream().filter(note -> note.getId() == noteId).findFirst();
        if (noteOptional.isPresent()) {
            notes.remove(noteOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
