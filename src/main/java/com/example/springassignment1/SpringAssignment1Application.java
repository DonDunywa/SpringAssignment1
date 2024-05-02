package com.example.springassignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAssignment1Application {


    public static void main(String[] args) {

        SpringApplication.run(SpringAssignment1Application.class, args);


    }

    @GetMapping("/allCourses")
    public String getAllCourses(@RequestParam(value = "courseName", defaultValue = " This course doesn't exist") String name) {
        StringBuilder response = new StringBuilder();
        response.append(FoundationCourses(name)).append("<br>");
        response.append(UndergraduateCourses(name)).append("<br>");
        response.append(HonoursCourses(name));
        return response.toString();
    }

    @GetMapping("/foundationCourse")
    private String FoundationCourses(@RequestParam(value = "courseName", defaultValue = " ") String name) {
        return String.format("2 Foundation courses offered in the Computer Science Department  %s!", name);

    }

    @GetMapping("/undergraduateCourse")

    private String UndergraduateCourses(@RequestParam(value = "courseName", defaultValue = " ") String name) {
        return String.format("5 Undergraduate courses offered in the Computer Science Department %s!", name);

    }

    @GetMapping("/honoursCourse")
    private String HonoursCourses(@RequestParam(value = "courseName", defaultValue = " ") String name) {
        return String.format("4 Honours courses offered in the Computer Science Department %s!", name);

    }
}