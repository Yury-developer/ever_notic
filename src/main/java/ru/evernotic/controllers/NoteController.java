package ru.evernotic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.evernotic.models.Note;
import ru.evernotic.services.NoteService;

import static ru.evernotic.constants.Constants.DEFAULT_LOCATION_LATITUDE;
import static ru.evernotic.constants.Constants.DEFAULT_LOCATION_LONGITUDE;


@Controller
@RequiredArgsConstructor // lombok пропишет те конструкторы, которые обязательны
public class NoteController {

    private final NoteService noteService; // если "final" то Spring при создании бина сразу его будет инжектить, а не тогда, когда к нему будем обращаться

    @GetMapping("/") // по GET запросу в корень сайта
    public String products(@RequestParam(name = "title", required = false) String title, Model model) { // Поиск по title, false -данный параметр необязателен // Model передаем для того, чтобы передаватькакие-нибудь  параметры в шаблонизатор
        model.addAttribute("notes", noteService.listNotes(title)); // т.о. передадим туда список всех записей / "notes" -ключь; noteService.listNotes() -значение

        model.addAttribute("defaultLatitude", DEFAULT_LOCATION_LATITUDE);
        model.addAttribute("defaultLongitude", DEFAULT_LOCATION_LONGITUDE);

        // Либо вернет весь список, есл title нет, либо отсортированный, если еешеду присутствует
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

    // я добавил
    @PostMapping("/note/getAll")
    public String getAll(Model model) {
        model.addAttribute("noteList", noteService.listAllNotes());
        return "note-print_all_notes";
    }
}
