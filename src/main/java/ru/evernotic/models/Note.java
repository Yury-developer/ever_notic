package ru.evernotic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


// @Entity, @Table, @Data, @AllArgsConstructor, @NoArgsConstructor, стобы HIBERNATE грамотно работал
@Entity //  Это не простой класс, а класс, который эмулирует таблицу из DB
@Table(name = "notes")
@Data // добавляет все геттеры и сеттеры, конструкторы, toString...
@AllArgsConstructor // добавит все конструкторы. т.е. конструктор со всеми полями, которые в нем присутствуют
@NoArgsConstructor // бе арг. -чтобы придерживаться понятия POJO
public class Note {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // укажем тип генерации и удалим из сервиса 'private long id = 0;'... Теперь логику инкремента берет на себя HIBERNATE
    @Column(name = "id") // конкретно укажем названия поля в DB
    private Long id;

    @Column(name = "createDate")
    private java.sql.Date createDate;
    @Column(name = "changeDate")
    private java.sql.Date changeDate;

    @Column(name = "title")
    private String title; // заголовок заметки
    @Column(name = "description", columnDefinition = "text") // не имеет огранияения по колву символов
    private String description; // содержимое заметки

    @Column(name = "notepad")
    private String notepad; // имя блокнота

    @Column(name = "latitude")
    private double latitude; // широта
    @Column(name = "longitude")
    private double longitude; // долгота

}
