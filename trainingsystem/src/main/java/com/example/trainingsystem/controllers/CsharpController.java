package com.example.trainingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CsharpController {

    @GetMapping("/csharp")
    public String showCourse(Model model) {
        return "csharp";
    }

    @GetMapping("/csharp/csharpintroduction")
    public String showIntroduction(Model model) {
        return "csharpintroduction";
    }

    @GetMapping("/csharp/csharpvariables")
    public String showVariables(Model model) {
        return "csharpvariables";
    }

    @GetMapping("/csharp/csharpcontrol-structures")
    public String showControlStructures(Model model) {
        return "csharpcontrol-structures";
    }

    @GetMapping("/csharp/csharpfunctions")
    public String showFunctions(Model model) {
        return "csharpfunctions";
    }

    @GetMapping("/csharp/csharpclasses")
    public String showClasses(Model model) {
        return "csharpclasses";
    }

    @GetMapping("/csharp/csharpoop")
    public String showOOP(Model model) {
        return "csharpoop";
    }
}
