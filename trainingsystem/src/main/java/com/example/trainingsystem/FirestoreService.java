package com.example.trainingsystem;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FirestoreService {
    private final Firestore db;

    public FirestoreService() {
        db = null;
    }


    public ApiFuture<DocumentReference> createCourse(Course course) {
        if (db != null) {
            CollectionReference collection = db.collection("courses");

            Map<String, Object> data = new HashMap<>();
            data.put("name", course.getName());
            data.put("description", course.getDescription());
            data.put("content", course.getContent());

            return collection.add(data);
        }
        return null;
    }

    public List<Course> getAllCourses() throws ExecutionException, InterruptedException {
        List<Course> courses = new ArrayList<>();
        if (db != null) {
            CollectionReference collection = db.collection("courses");
            ApiFuture<QuerySnapshot> querySnapshot = collection.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                Course course = document.toObject(Course.class);
                courses.add(course);
            }
        }
        return courses;
    }
}
