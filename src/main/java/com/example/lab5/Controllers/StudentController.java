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
@RequestMapping(path = "/api/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        List<Student> listToReturn = new ArrayList<>();
        for (Class group : ClassContainer.listOfClasses) {
            listToReturn.addAll(group.studentsList);
        }

        return listToReturn;
    }

    @PostMapping(path = "{id}")
    public void registerStudent(@ModelAttribute Student student, @PathVariable("id") int id) {
        System.out.println(student);
        for (Class group : ClassContainer.listOfClasses) {
            if(group.ID == id) {
                group.addStudent(student);
            }
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        for (Class group : ClassContainer.listOfClasses) {
            List<Student> listToRemove = new ArrayList<>();

            for (Student student : group.studentsList) {
                if(student.ID == id) {
                    listToRemove.add(student);

                    System.out.println("We got him!");
                }
            }

            if(listToRemove.isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                );
            }

            for (var student : listToRemove) {
                group.studentsList.remove(student);
            }
        }
    }
}
