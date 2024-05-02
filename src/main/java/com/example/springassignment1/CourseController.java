package com.example.springassignment1;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Valid
@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;



    @GetMapping("/read")
    public Iterable<Course> getCourse() {
        Iterable<Course> courses = courseRepository.findAll();
        courses.forEach(course -> course.setCategory(course.getCategory()));
        return courses;
    }

    @GetMapping("/read/{id}")
    public Course findCourseById(@PathVariable Integer id) {
        return courseRepository.findCourseById(id);
    }
    @PostMapping("/create")
    public String createCourse(@Valid@RequestParam String name, @Valid@RequestParam String description, @RequestParam String category) {
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);

        // Set the category based on the selected value from the form
        course.setCategory(category);

        courseRepository.save(course);
        return "Added new course to system!";
    }






    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourse(@Valid@PathVariable Integer id,@Valid @RequestBody Course updatedCourse) {
        Course existingCourse = courseRepository.findCourseById(id);
        if (existingCourse != null) {
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setDescription(updatedCourse.getDescription());
            try {
                courseRepository.save(existingCourse);
                return ResponseEntity.ok("Course updated successfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to update course: " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        Course course = courseRepository.findCourseById((id));
        if (course != null) {
            courseRepository.delete(course);
            return "Course deleted successfully";
        }
        return "Course not found";
    }


}