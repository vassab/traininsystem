package com.example.trainingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/")
public class swagerController {

    @GetMapping("/cplusplus")
    public String showCourse() {
        return "cplusplus";
    }

    @GetMapping("/introduction")
    public String showIntroduction() {
        return "cplusplusintroduction";
    }

    @GetMapping("/variables")
    public String showVariables() {
        return "cplusplusvariables";
    }

    @GetMapping("/control-structures")
    public String showControlStructures() {
        return "cpluspluscontrolstructures";
    }

    @GetMapping("/functions")
    public String showFunctions() {
        return "cplusplusfunctions";
    }

    @GetMapping("/classes")
    public String showClasses() {
        return "cplusplusclasses";
    }

    @GetMapping("/oop")
    public String showOOP() {
        return "cplusplusoop";
    }
}

