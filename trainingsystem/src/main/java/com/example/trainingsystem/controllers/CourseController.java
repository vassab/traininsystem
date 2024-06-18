package com.example.trainingsystem.controllers;

import com.example.trainingsystem.FirestoreService;
import com.example.trainingsystem.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class CourseController {

    private final FirestoreService firestoreService;

    @Autowired
    public CourseController(FirestoreService firestoreService) {
        this.firestoreService = firestoreService;
    }

    @GetMapping("/listofcourses")
    public String listCourses(Model model) throws ExecutionException, InterruptedException {
        List<Course> courses = firestoreService.getAllCourses();
        model.addAttribute("courses", courses);
        return "listofcourses";
    }
}