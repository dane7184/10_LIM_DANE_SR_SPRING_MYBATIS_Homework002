package org.example.controller;

import org.example.model.entity.Student;
import org.example.model.request.StudentRequest;
import org.example.model.response.ApiResponse;
import org.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent
            (@RequestParam(name = "page", required = false, defaultValue = "1") int page,
             @RequestParam(name = "size", required = false, defaultValue = "10") int size){

        List<Student> studentList = studentService.getAllStudent(page, size);

        ApiResponse response = ApiResponse.<List<Student>>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Get Students Successfully")
                .payload(studentList)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById (@PathVariable("student-id") Long studentId){

        List<Student> studentList = studentService.getStudentById(studentId);

        ApiResponse response = ApiResponse.<List<Student>>builder()
                    .isSuccess(true)
                    .status(HttpStatus.OK)
                    .message("Get Students By ID Successfully")
                    .payload(studentList)
                    .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> saveStudent(@RequestBody StudentRequest request){

        Student studentList = studentService.saveStudent(request);

        ApiResponse response = ApiResponse.<Student>builder()
                .isSuccess(true)
                .status(HttpStatus.CREATED)
                .message("Create Students Successfully")
                .payload(studentList)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudentById (
            @PathVariable("student-id") Long studentId,
            @RequestBody StudentRequest request){

        Student student = studentService.updateStudentById(studentId, request);

        ApiResponse response = ApiResponse.<Student>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Update Students Successfully")
                .payload(student)
                .timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById (@PathVariable("student-id") Long studentId){

        Student student = studentService.deleteStudentById(studentId);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Delete Student Successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.ok(response);
    }
}
