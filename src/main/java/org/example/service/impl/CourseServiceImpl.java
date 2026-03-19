package org.example.service.impl;

import org.example.model.entity.Course;
import org.example.model.request.CourseRequest;
import org.example.repository.CourseRepository;
import org.example.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(int page, int size) {

        int offSet = (page - 1) * size;
        return courseRepository.getAllCourses(offSet, size);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course addCourse(CourseRequest request) {
        return courseRepository.addCourse(request);
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest request) {
        return courseRepository.updateCourseeById(courseId, request);
    }

    @Override
    public Course deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }
}
