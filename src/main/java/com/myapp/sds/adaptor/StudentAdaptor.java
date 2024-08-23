package com.myapp.sds.adaptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.sds.dto.StudentDTO;
import com.myapp.sds.model.Student;

public final class StudentAdaptor {

    public static StudentDTO toStudentDTO(Student student){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(student,StudentDTO.class);
    }

    public static Student toStudent(StudentDTO studentDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(studentDTO,Student.class);
    }
}
