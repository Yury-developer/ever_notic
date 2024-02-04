package ru.evernotic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/") // по GET запросу в корень сайта
    public String products() {

        return "products";
    }
}
