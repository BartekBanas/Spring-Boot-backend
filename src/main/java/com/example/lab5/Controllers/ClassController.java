package com.example.lab5.Controllers;

import com.example.lab5.Class;
import com.example.lab5.ClassContainer;
import com.example.lab5.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/course")
public class ClassController {

    @GetMapping
    public List<Class> getClasses() {
        return ClassContainer.listOfClasses;
    }


    @DeleteMapping(path = "{id}")
    public void deleteClass(@PathVariable("id") int id) {
        for (Class group : ClassContainer.listOfClasses) {
            System.out.println("On the hunt for class " + id);

            if (group.ID == id) {
                ClassContainer.listOfClasses.remove(group);

                for (Student student : group.studentsList) {
                    group.studentsList.remove(student);
                }

                System.out.println("We got him!");
            }
        }
    }
}
