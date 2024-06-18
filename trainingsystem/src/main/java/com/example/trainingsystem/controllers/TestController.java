package com.example.trainingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/test")
    public String showTest(@RequestParam String course, Model model) {
        model.addAttribute("course", course);
        return "test";
    }

    @PostMapping("/test")
    public String submitTest(
            @RequestParam String course,
            @RequestParam Map<String, String> params,
            Model model) {

        Map<String, String> correctAnswers = getCorrectAnswers(course);
        int score = 0;

        for (String question : correctAnswers.keySet()) {
            if (correctAnswers.get(question).equals(params.get(question))) {
                score++;
            }
        }

        model.addAttribute("score", score);
        model.addAttribute("total", correctAnswers.size());
        return "result";
    }

    private Map<String, String> getCorrectAnswers(String course) {
        Map<String, String> answers = new HashMap<>();

        switch (course) {
            case "csharp":
                answers.put("q1", "Microsoft");
                answers.put("q2", "int");
                answers.put("q3", "if");
                break;
            case "cplusplus":
                answers.put("q1", "Компилируемый");
                answers.put("q2", "Гибкость");
                answers.put("q3", "int main()");
                break;
            case "unity":
                // Добавьте правильные ответы для курса Unity
                break;
        }
        return answers;
    }
}

