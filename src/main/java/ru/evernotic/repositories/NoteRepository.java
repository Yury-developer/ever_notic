package ru.evernotic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evernotic.models.Note;

import java.util.List;

// Унаследуемся от JpaRepository и получим 'из коробки' все методы
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByTitle(String title); // вернет список заметок, имеющих данный заголовок
}
