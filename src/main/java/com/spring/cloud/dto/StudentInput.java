package com.spring.cloud.dto;

import lombok.Data;

@Data
public class StudentInput {
    private String name;
    private String rollNumber;
    private Long mobile;
    private String address;

}
