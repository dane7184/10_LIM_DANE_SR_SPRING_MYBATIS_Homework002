package org.example.service;

import org.example.model.entity.Instructor;
import org.example.model.request.InstructorsRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor(int page, int size);

    Instructor getInstructorById(Long instructorId);

    Instructor addInstructor(InstructorsRequest request);

    Instructor updateInstructorById(Long instructorId, InstructorsRequest request);

    Instructor deleteInstructorById(Long instructorId);
}
