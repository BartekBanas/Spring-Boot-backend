package com.example.lab5.Controllers;

import com.example.lab5.Class;
import com.example.lab5.ClassContainer;
import com.example.lab5.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        List<Student> listToReturn = new ArrayList<>();
        for (Class group : ClassContainer.listOfClasses) {
            listToReturn.addAll(group.studentsList);
        }

        return listToReturn;
    }
}
