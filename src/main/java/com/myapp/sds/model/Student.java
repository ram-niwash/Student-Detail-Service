package com.myapp.sds.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student", schema = "student_service")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long studentId;

    @Column(name="NAME")
    private String name;

    @Column(name="ROLL_NUMBER")
    private int rollNumber;

    @Column(name="COURSE")
    private String course;

    @Column(name="FEE")
    private double fee;

}
