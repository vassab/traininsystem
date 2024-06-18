package com.example.trainingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewCourseController {

    @GetMapping("/new-course")
    public String newcourse() {
        return "new-course";
    }
}