package org.example.service.impl;

import org.example.model.entity.Instructor;
import org.example.model.request.InstructorsRequest;
import org.example.repository.InstructorRepository;
import org.example.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructor(int page, int size) {

        int offSet = (page - 1) * size;

        return instructorRepository.getAllInstructor(offSet, size);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {

        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor addInstructor(InstructorsRequest request) {
        return instructorRepository.addInstructor(request);
    }

    @Override
    public Instructor updateInstructorById(Long instructorId, InstructorsRequest request) {
        return instructorRepository.updateInstrouctorById(instructorId, request);
    }

    @Override
    public Instructor deleteInstructorById(Long instructorId) {
        return instructorRepository.deleteInstructorById(instructorId);
    }

}
