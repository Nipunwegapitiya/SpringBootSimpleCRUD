package com.example.demo.service.Impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (!existingCourse.isPresent()) {
            return null;
        }
        existingCourse.get().setName(course.getName());
        existingCourse.get().setDescription(course.getDescription());
        return courseRepository.save(existingCourse.get());

//        courseRepository.deleteAllById();

    }

    @Override
    public boolean deleteCourse(Long id) {

        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }


}
