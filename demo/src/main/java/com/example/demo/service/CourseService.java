package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    Course createCourse(Course course);

    Course updateCourse(Long id, Course course);

    boolean deleteCourse(Long id);
}
