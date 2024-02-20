package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String getHome() {
        return "HOME";
    }

    @GetMapping("/test")
    public String getTest() {
        return "TEST";
    }

    @GetMapping("/person")
    public Person getPersons() {
        Person person = new Person();
        person.setAge(15);
        person.setName("Test");
        return person;
    }
}

class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}