package ru.evernotic.services;

import org.springframework.stereotype.Service;
import ru.evernotic.models.Note;

import java.util.ArrayList;
import java.util.List;


@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private long id = 0;

    {
        notes.add(new Note(++id,
                new java.sql.Date(124, 00, 01),
                new java.sql.Date(124, 00, 11),
                "title1", "description1",
                "notepad1",
                31.23, 52.45));
        notes.add(new Note(++id,
                new java.sql.Date(123, 01, 02),
                new java.sql.Date(123, 01, 22),
                "title2", "description2",
                "notepad2",
                31.24, 52.46));
        notes.add(new Note(++id,
                new java.sql.Date(125, 02, 03),
                new java.sql.Date(125, 02, 30),
                "title3", "description3",
                "notepad3",
                31.25, 52.47));
    }

    public List<Note> listNotes() {
        return notes;
    }

    public void saveNote(Note note) {
        note.setId(++id);
        notes.add(note);
    }

    public void deleteNote(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    public Note getNoteById(Long id) {
        for (Note note: notes) {
            if (note.getId().equals(id)) return note;
        }
        return null;
    }
}
