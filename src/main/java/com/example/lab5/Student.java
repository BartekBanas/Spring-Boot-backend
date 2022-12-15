package com.example.lab5;

public class Student implements Comparable<Student> {
    public int ID;
    String name;
    String surname;

    public Student() {
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    StudentCondition studentCondition;
    int birthYear;

    double points;

    public double getPoints() {
        return points;
    }

    public Student(String name, String surname, StudentCondition studentCondition, int birthYear, double points) {
        this.name = name;
        this.surname = surname;
        this.studentCondition = studentCondition;
        this.birthYear = birthYear;
        this.points = points;
    }

    public Student(int ID, String name, String surname, StudentCondition studentCondition, int birthYear, double points) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.studentCondition = studentCondition;
        this.birthYear = birthYear;
        this.points = points;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.studentCondition = StudentCondition.absent;
        this.birthYear = 2000;
    }

    public Student(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.studentCondition = StudentCondition.absent;
        this.birthYear = 2000;
        this.ID = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", points=" + points +
                '}';
    }

    public void print() {
        System.out.println("Student " + name + " " + surname + "");
        System.out.println("- Student's Condition: " + studentCondition);
        System.out.println("- Birth Year: " + birthYear);
        System.out.println("- Amount of points: " + points);
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.surname.compareTo(otherStudent.surname);
    }
}