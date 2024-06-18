package com.example.trainingsystem.controllers;

import com.example.trainingsystem.Course;
import com.example.trainingsystem.firebase.FirebaseAuth;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

@Controller
public class AuthController {

    @Autowired
    public FirebaseAuth bd;
    private DocumentReference firebaseAuth;

    @GetMapping("/fgf")
    public String testDB(Model model) throws ExecutionException, InterruptedException {
        CollectionReference collection = bd.GetFireBase().collection("student");
        Future<QuerySnapshot> query = collection.get();

        QuerySnapshot querySnapshot = query.get();
        List<String> studentNames = new ArrayList<>();

        for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
            String name = document.getString("name");
            String lastName = document.getString("last name");
            studentNames.add(name + " " + lastName);
            System.out.println("Полное имя: " + name + " " + lastName);
        }

        model.addAttribute("studentNames", studentNames);

        return "fgf";
    }
    @PostMapping("/listofcourses")
    public String getCourses(Model model) {
        CollectionReference courses = firebaseAuth.getFirestore().collection("courses");
        List<String> courseCplusplus = new ArrayList<>();

        try {
            QuerySnapshot querySnapshot = courses.get().get();
            for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
                String name = document.getString("name");
                String content = document.getString("content");
                courseCplusplus.add(name + " " + content);
                System.out.println("Полное имя: " + name + " " + content);
            }
        } catch (InterruptedException | ExecutionException e) {
            Logger.getLogger(CourseController.class.getName()).severe("Error accessing Firestore: " + e.getMessage());
        }

        model.addAttribute("courseName", courseCplusplus);
        return "listofcourses";
        }
    }



