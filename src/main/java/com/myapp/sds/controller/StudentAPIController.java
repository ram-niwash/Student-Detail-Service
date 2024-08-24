package com.myapp.sds.controller;

import com.myapp.sds.dto.StudentDTO;
import com.myapp.sds.exception.StudentServiceException;
import com.myapp.sds.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentAPIController {

    @Autowired
    private StudentService studentService;

     @PostMapping(value = "/save")
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO) throws StudentServiceException {
        studentDTO =  this.studentService.save(studentDTO);
        return ResponseEntity.ok(studentDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable Long id) throws StudentServiceException {
        StudentDTO studentDTO = this.studentService.delete(id);
        return ResponseEntity.ok(studentDTO);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO studentDTO) throws StudentServiceException {
        StudentDTO studentDTO1 = this.studentService.update(studentDTO);
        return ResponseEntity.ok(studentDTO1);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<StudentDTO> get(@PathVariable Long id) throws StudentServiceException {
        StudentDTO studentDTO = this.studentService.getById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping(value = "/get/{offset}/{limit}")
    public ResponseEntity<List<StudentDTO>> get(@PathVariable Integer offset, @PathVariable Integer limit) throws StudentServiceException {
        List<StudentDTO> list = this.studentService.get(offset,limit);
        return ResponseEntity.ok(list);
    }
}
