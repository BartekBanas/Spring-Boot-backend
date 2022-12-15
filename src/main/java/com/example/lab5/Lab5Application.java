package com.example.lab5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab5Application {

    public static void main(String[] args) {
        //InitializeThis();

        SpringApplication.run(Lab5Application.class, args);
    }


    private static void InitializeThis() {
        Student s1 = new Student("John", "Cena", StudentCondition.present, 2000, 7);
        Student s2 = new Student("Alex", "Woodrow", StudentCondition.present, 2001, 0);
        Student s3 = new Student("Petter", "Griffin", StudentCondition.present, 1998, 2);
        Student s4 = new Student("Randy", "Marsh", StudentCondition.present, 1999, 5);
        Student s5 = new Student("Matt", "Wentworth", StudentCondition.present, 2000, 9);

        ClassContainer.addClass("Programming", 8);
        ClassContainer.addClass("metallurgy", 100);

        ClassContainer.garbageClassMap.get("Programming").addStudent(s1);
        ClassContainer.garbageClassMap.get("Programming").addStudent(s2);
        ClassContainer.garbageClassMap.get("Programming").addStudent(s3);
        ClassContainer.garbageClassMap.get("Programming").addStudent(s4);
        ClassContainer.garbageClassMap.get("Programming").addStudent(s5);
    }
}