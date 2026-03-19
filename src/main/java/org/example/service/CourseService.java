package org.example.service;

import org.example.model.entity.Course;
import org.example.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(int page, int size);

    Course getCourseById(Long courseId);

    Course addCourse(CourseRequest request);

    Course updateCourseById(Long courseId, CourseRequest request);

    Course deleteCourseById(Long courseId);

}
