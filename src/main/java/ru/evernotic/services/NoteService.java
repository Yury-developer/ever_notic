package ru.evernotic.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evernotic.models.Note;
import ru.evernotic.repositories.NoteRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j // чтобы смотреть логирование
@RequiredArgsConstructor
public class NoteService {
//    private final List<Note> notes = new ArrayList<>();
//    private long id = 0;
//
//    {
//        notes.add(new Note(++id,
//                new java.sql.Date(124, 00, 01),
//                new java.sql.Date(124, 00, 11),
//                "title1", "description1",
//                "notepad1",
//                31.23, 52.45));
//        notes.add(new Note(++id,
//                new java.sql.Date(123, 01, 02),
//                new java.sql.Date(123, 01, 22),
//                "title2", "description2",
//                "notepad2",
//                31.24, 52.46));
//        notes.add(new Note(++id,
//                new java.sql.Date(125, 02, 03),
//                new java.sql.Date(125, 02, 30),
//                "title3", "description3",
//                "notepad3",
//                31.25, 52.47));
//    }

    private final NoteRepository noteRepository;

    public List<Note> listNotes(String title) {
        if (title != null) return noteRepository.findByTitle(title);
        return noteRepository.findAll(); // если нету - вернуть всё что есть
    }

    public void saveNote(Note note) {
        log.info("Saving {}", note); // логируем
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null); // возвращает объект Optional/ Если товар не найден - вернем null
    }


    // я добавил
    public List<Note> listAllNotes() {
        return noteRepository.findAll();
    }
}
