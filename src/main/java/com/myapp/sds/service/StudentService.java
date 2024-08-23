package com.myapp.sds.service;

import com.myapp.sds.dto.StudentDTO;
import com.myapp.sds.exception.StudentServiceException;

import java.util.List;

public interface StudentService {

    StudentDTO getById(Long id) throws StudentServiceException;

    StudentDTO save(StudentDTO studentDTO) throws StudentServiceException;

    StudentDTO delete(Long id) throws StudentServiceException;

    StudentDTO update(StudentDTO studentDTO) throws StudentServiceException;

    List<StudentDTO> get(Integer offset, Integer limit) throws StudentServiceException;
}
