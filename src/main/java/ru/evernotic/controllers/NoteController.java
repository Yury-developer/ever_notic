package ru.evernotic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.evernotic.models.Note;
import ru.evernotic.services.NoteService;


@Controller
@RequiredArgsConstructor // lombok пропишет те конструкторы, которые обязательны
public class NoteController {

    private final NoteService noteService; // если "final" то Spring при создании бина сразу его будет инжектить, а не тогда, когда к нему будем обращаться

    @GetMapping("/") // по GET запросу в корень сайта
    public String products(Model model) { // Model передаем для того, чтобы передаватькакие-нибудь  параметры в шаблонизатор
        model.addAttribute("notes", noteService.listNotes()); // т.о. передадим туда список всех записей / "notes" -ключь; noteService.listNotes() -значение

        System.out.println("NoteController public String products(Model model)");
        return "notes";
    }


    @GetMapping("/note/{id}") // просмотр подробной инфы о каждом товаре
    public String noteInfo(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "note-info";
    }


    @PostMapping("/note/create")
    public String createNote(Note note) {
        noteService.saveNote(note);
        return "redirect:/"; // обновить страницу
    }

    @PostMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/"; // обновить страницу
    }
}
