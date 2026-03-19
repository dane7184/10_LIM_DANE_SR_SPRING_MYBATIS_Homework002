package org.example.controller;

import org.example.model.entity.Course;
import org.example.model.request.CourseRequest;
import org.example.model.response.ApiResponse;
import org.example.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {

        List<Course> courseList = courseService.getAllCourses(page, size);

        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Get Course Successfully")
                .payload(courseList)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Long courseId){

        Course course = courseService.getCourseById(courseId);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Get Course Successfully")
                .payload(course)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest request){

        Course course = courseService.addCourse(request);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Get Course Successfully")
                .payload(course)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable("course-id") Long courseId, @RequestBody CourseRequest request){

        Course course = courseService.updateCourseById(courseId, request);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Update Course Successfully")
                .payload(course)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable("course-id") Long courseId ){

        Course course = courseService.deleteCourseById(courseId);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Delete Course Successfully")
                .payload(course)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
