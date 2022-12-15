package com.example.lab5;

import java.util.*;

public class ClassContainer {
    public static String name = "College";
    public static int ID = 0;

    public ClassContainer() {
    }

    public ClassContainer(String name) {
        ClassContainer.name = name;
    }

    static Map<String, Class> garbageClassMap = new LinkedHashMap<>();

    public static List<Class> listOfClasses = new ArrayList<>();

    public static void setClass(Class clas) {
        garbageClassMap.put(name, new Class(clas.className, clas.capacity, clas.ID));
        listOfClasses.add(garbageClassMap.get(name));
    }

    public static void addClass(String name, int capacity) {
        garbageClassMap.put(name, new Class(name, capacity));
        listOfClasses.add(garbageClassMap.get(name));
    }

    public static void addClass(String name) {
        garbageClassMap.put(name, new Class(name));
        listOfClasses.add(garbageClassMap.get(name));
    }

    public static void removeClass(String name) {
        garbageClassMap.remove(name);
    }

    public static List<Class> findEmpty() {
        List<Class> listToReturn = new ArrayList<>();

        for (Map.Entry<String, Class> entry : garbageClassMap.entrySet())
        {
            if(entry.getValue().studentsList.size() == 0) {
                listToReturn.add(entry.getValue());
            }
        }

        return listToReturn;
    }

    public static void summary() {
        System.out.println("Summary of a Class Container:");
        for (Map.Entry<String, Class> entry : garbageClassMap.entrySet())
        {
            double amountOfStudents =  entry.getValue().studentsList.size();
            double maximumCapacity = entry.getValue().capacity;

            System.out.println("Class " + entry.getKey() + " is " +
                    amountOfStudents / maximumCapacity * 100 + "% full");
        }   System.out.println();
    }

    public static void sortClasses() {
        Class temp;

        for (int i = 0; i < listOfClasses.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (listOfClasses.get(i).studentsList.size() > listOfClasses.get(j).studentsList.size()) {
                    temp = listOfClasses.get(i);
                    listOfClasses.set(i, listOfClasses.get(j));
                    listOfClasses.set(j, temp);
                }
            }
        }
    }
}