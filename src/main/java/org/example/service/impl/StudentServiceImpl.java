package org.example.service.impl;

import org.example.model.entity.Student;
import org.example.model.request.StudentRequest;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent(int page, int size) {

        int offSet = (page - 1) * size;
        return studentRepository.getAllStudent(offSet, size);
    }

    @Override
    public List<Student> getStudentById(Long studentId) {

        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest request) {

        Student student = studentRepository.saveStudent(request);

        if (request.getCourseId() != null) {
            for (Long courseId : request.getCourseId()) {
                studentRepository.insertStudentCourse(student.getStudentId(), courseId);
            }
        }

        return studentRepository.getStudentByIds(student.getStudentId());
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest request) {

        studentRepository.updateStudentById(studentId, request);

        studentRepository.deleteStudentCourses(studentId);

        if (request.getCourseId() != null) {
            for (Long courseId : request.getCourseId()) {
                studentRepository.insertStudentCourse(studentId, courseId);
            }
        }

        return studentRepository.getStudentByIds(studentId);
    }

    @Override
    public Student deleteStudentById(Long studentId) {
        return studentRepository.deleteStudentById(studentId);
    }
}
