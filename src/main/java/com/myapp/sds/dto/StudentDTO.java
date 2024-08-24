package com.myapp.sds.dto;

import lombok.Data;


@Data
public class StudentDTO {

    private Long studentId;

    private String name;

    private int rollNumber;

    private String course;

    private double fee;
}
