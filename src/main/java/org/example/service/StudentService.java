package org.example.service;

import org.example.model.entity.Student;
import org.example.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(int page, int size);

    List<Student> getStudentById(Long studentId);

    Student saveStudent(StudentRequest request);

    Student updateStudentById(Long studentId, StudentRequest request);

    Student deleteStudentById(Long studentId);
}
