package com.example.lab5.Controllers;

import com.example.lab5.Class;
import com.example.lab5.ClassContainer;
import com.example.lab5.Student;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerStudent(Student student) {
        System.out.println(student);
        for (Class group : ClassContainer.listOfClasses) {
            if(group.ID == 1) {
                group.addStudent(student);
            }
        }
    }

    @DeleteMapping
    public void deleteStudent(int ID) {
        for (Class group : ClassContainer.listOfClasses) {
            for (Student student : group.studentsList) {
                if(student.ID == ID) {
                    group.studentsList.remove(student);

                    System.out.println("We got him!");
                }
            }
        }
    }

//    @DeleteMapping
//    @RequestMapping(path = "/api/student/:{id} ")
//    public int deleteStudent(){
//
//    }
}
