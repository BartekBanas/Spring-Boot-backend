package com.example.lab5.Controllers;

import com.example.lab5.Class;
import com.example.lab5.ClassContainer;
import com.example.lab5.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/course")
public class ClassController {

    @GetMapping
    public List<Class> getClasses() {
        return ClassContainer.listOfClasses;
    }

    @GetMapping(path = "{id}/students")
    public List<Student> getStudentsFromClass(@PathVariable("id") int id) {
        for (Class course : ClassContainer.listOfClasses) {
            if (course.ID == id) {
                if (!course.studentsList.isEmpty()) {
                    return course.studentsList;
                }
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @GetMapping(path = "{id}/fill")
    public String getFillingPercentage(@PathVariable("id") int id) {
        for (Class course : ClassContainer.listOfClasses) {
            if (course.ID == id) {
                double max = course.capacity;
                double actual = course.studentsList.size();
                double result = actual / max * 100;

                return String.valueOf(result) + "%";
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @DeleteMapping(path = "{id}")
    public void deleteClass(@PathVariable("id") int id) {
        List<Class> listToRemove = new ArrayList<>();
        for (Class group : ClassContainer.listOfClasses) {
            System.out.println("On the hunt for class " + id);

            if (group.ID == id) {
                group.studentsList.clear();
                listToRemove.add(group);

                System.out.println("We got him!");
            }
        }

        if (listToRemove.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        for (var course : listToRemove) {
            ClassContainer.listOfClasses.remove(course);
        }
    }


}
