package com.spring.cloud.service;

import com.spring.cloud.dto.StudentInput;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private static Map<String, StudentInput> studentMap = new HashMap<>();
    public UUID registerStudentDetails(StudentInput input){
        if(input != null){
            UUID studentId = UUID.randomUUID();
            studentMap.put(studentId.toString(), input);
            return studentId;
        }
        return null;
    }

    public StudentInput getStudentDetailsById(UUID studentId){
        return studentMap.get(studentId.toString());
    }

    public List<StudentInput> getAllStudentDetails(){
        return new ArrayList<>(studentMap.values());
    }
}
