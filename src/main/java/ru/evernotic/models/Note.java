package ru.evernotic.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;


@Data // добавляет все геттеры и сеттеры, конструкторы, toString...
@AllArgsConstructor // добавит все конструкторы. т.е. конструктор со всеми полями, которые в нем присутствуют
public class Note {

    private Long id;

    private java.sql.Date createDate;
    private java.sql.Date changeDate;

    private String title; // заголовок заметки
    private String description; // содержимое заметки

    private String notepad; // имя блокнота

    private double latitude; // широта
    private double longitude; // долгота

}
