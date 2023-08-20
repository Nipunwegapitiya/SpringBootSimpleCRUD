package com.example.demo.controller.courseController;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") Long id ,@RequestBody Course course ){
        Course updatedCourse = courseService.updateCourse(id,course);
        if(updatedCourse == null){
            return new ResponseEntity<>("Course not found",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteCourse(@PathVariable("id") Long id){
        boolean course= courseService.deleteCourse(id);
        if(course == false){
            return new ResponseEntity<>("Entity not found",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);

    }
}
