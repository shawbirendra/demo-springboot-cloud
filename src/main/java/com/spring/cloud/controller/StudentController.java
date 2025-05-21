package com.spring.cloud.controller;

import com.spring.cloud.dto.ApiResponse;
import com.spring.cloud.dto.StudentInput;
import com.spring.cloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
//register endpoints  : localhost:8080/api/v1/student/save-student-details
//get student details : localhost:8080/api/v1/student/getDetails
    //localhost:8080/api/v1/student/getAllStudents
    //33edf1c3-a452-48a2-921d-0effa052a7de
    @Autowired
    private StudentService studentService;
    @PostMapping("/save-student-details")
    public ResponseEntity<ApiResponse<UUID>> insertStudentDetails(@RequestBody StudentInput studentInput){
        UUID studentId = studentService.registerStudentDetails(studentInput);

        ApiResponse<UUID> response = new ApiResponse<>("Success",
                "Student details saved successfully",
                studentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity<StudentInput> getStudentDetails(@PathVariable UUID id){
        return ResponseEntity.ok(studentService.getStudentDetailsById(id));
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentInput>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudentDetails());
    }
}
