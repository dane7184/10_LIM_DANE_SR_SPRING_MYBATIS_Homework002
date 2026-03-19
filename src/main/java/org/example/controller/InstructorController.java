package org.example.controller;

import org.example.model.entity.Instructor;
import org.example.model.request.InstructorsRequest;
import org.example.model.response.ApiResponse;
import org.example.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructor
            (@RequestParam(name = "page", required = false, defaultValue = "1") int page,
             @RequestParam(name = "size", required = false, defaultValue = "10") int size){

        List<Instructor> instructors = instructorService.getAllInstructor(page, size);

        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Get Instructor Successfully")
                .payload(instructors)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId){

        Instructor instructors = instructorService.getInstructorById(instructorId);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Get Instructor By ID Successfully")
                .payload(instructors)
                .timestamp(Instant.now()).build();

         return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody InstructorsRequest request){

        Instructor instructors = instructorService.addInstructor(request);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Create Instructor Successfully")
                .payload(instructors)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(
            @PathVariable("instructor-id") Long instructorId,
            @RequestBody InstructorsRequest request ) {

        Instructor instructors = instructorService.updateInstructorById(instructorId, request);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Update Instructor Successfully")
                .payload(instructors)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable("instructor-id") Long instructorId){

        Instructor instructors = instructorService.deleteInstructorById(instructorId);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .isSuccess(true)
                .status(HttpStatus.OK)
                .message("Create Instructor Successfully")
                .payload(instructors)
                .timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
