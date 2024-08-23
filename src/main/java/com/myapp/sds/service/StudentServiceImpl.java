package com.myapp.sds.service;

import com.myapp.sds.adaptor.StudentAdaptor;
import com.myapp.sds.dto.StudentDTO;
import com.myapp.sds.exception.StudentServiceException;
import com.myapp.sds.model.Student;
import com.myapp.sds.repository.StudentRepository;
import org.apache.coyote.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getById(Long id) throws StudentServiceException{
        Optional<Student> optional = this.studentRepository.findById(id);
        if(optional.isPresent()){
            return StudentAdaptor.toStudentDTO(optional.get());
        }else{
            throw new StudentServiceException("Student not found");
        }
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) throws StudentServiceException {
        Student student = this.studentRepository.save(StudentAdaptor.toStudent(studentDTO));
        return StudentAdaptor.toStudentDTO(student);
    }

    @Override
    public StudentDTO delete(Long id) throws StudentServiceException {
        Optional<Student> optional = this.studentRepository.findById(id);
        if(optional.isPresent()){
            this.studentRepository.deleteById(id);
            return StudentAdaptor.toStudentDTO(optional.get());
        }else{
            throw new StudentServiceException("Student not found");
        }
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) throws StudentServiceException {
        Optional<Student> optional = this.studentRepository.findById(studentDTO.getStudentId());
        Student student = null;
        if(optional.isPresent()){
            student = optional.get();
            if(studentDTO.getName() != null && !studentDTO.getName().isBlank()){
                student.setName(studentDTO.getName());
            }
            if(studentDTO.getCourse() !=null && !studentDTO.getCourse().isBlank()){
                student.setCourse(studentDTO.getCourse());
            }
            if(studentDTO.getRollNumber() > 0){
                student.setRollNumber(studentDTO.getRollNumber());
            }
            if(studentDTO.getFee() > 0.0){
                student.setFee(studentDTO.getFee());
            }
            student = this.studentRepository.save(student);
        }else{
            student = this.studentRepository.save(StudentAdaptor.toStudent(studentDTO));
        }
        return StudentAdaptor.toStudentDTO(student);
    }

    @Override
    public List<StudentDTO> get(Integer offset, Integer limit) throws StudentServiceException {
        Pageable pageable = PageRequest.of(offset.intValue(), limit);
        Page<Student> page = this.studentRepository.findAll(pageable);
        if(page.getSize()==0){
            throw new StudentServiceException("No student found");
        }
        List<StudentDTO> list = new ArrayList<>(page.getSize());
        for(Student student: page){
            list.add(StudentAdaptor.toStudentDTO(student));
        }
        return list;
    }
}
