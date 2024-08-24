package com.myapp.sds.controller;

import com.myapp.sds.dto.StudentDTO;
import com.myapp.sds.exception.StudentServiceException;
import com.myapp.sds.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentUIController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value={"/ui/home"})
    public ModelAndView homePage(){
        return new ModelAndView("home");
    }

    @GetMapping(value={"/ui/show/{offset}/{limit}","/ui/show"})
    public ModelAndView showStudents(@PathVariable(required = false) Integer offset,
                                     @PathVariable(required = false) Integer limit,
                                     Model model) throws StudentServiceException {
        if(offset == null){
            offset = 0;
        }
        if(limit == null){
            limit = 10;
        }
        List<StudentDTO> list = this.studentService.get(offset,limit);
        model.addAttribute("students",list);
        return new ModelAndView("student-show");
    }

    @GetMapping(value={"/ui/add"})
    public ModelAndView add(Model model) throws StudentServiceException {
        model.addAttribute("student", new StudentDTO());
        return new ModelAndView("student-add");
    }

    @PostMapping(value={"/ui/add"})
    public ModelAndView add(@ModelAttribute StudentDTO studentDTO,  Model model) throws StudentServiceException {
        StudentDTO studentDTO1 = this.studentService.save(studentDTO);
        return new ModelAndView("redirect:/ui/home");
    }

    @GetMapping(value={"/ui/update"})
    public ModelAndView update(Model model) throws StudentServiceException {
        model.addAttribute("student", new StudentDTO());
        return new ModelAndView("student-update");
    }

    @PostMapping(value={"/ui/update"})
    public ModelAndView update(@ModelAttribute StudentDTO studentDTO,  Model model) throws StudentServiceException {
        StudentDTO studentDTO1 = this.studentService.update(studentDTO);
        return new ModelAndView("redirect:/ui/home");
    }

    @GetMapping(value={"/ui/delete"})
    public ModelAndView delete(Model model) throws StudentServiceException {
        model.addAttribute("student", new StudentDTO());
        return new ModelAndView("student-delete");
    }

    @PostMapping(value={"/ui/delete"})
    public ModelAndView delete(@ModelAttribute StudentDTO studentDTO) throws StudentServiceException {
        System.out.println("DELETING "+studentDTO.getStudentId());
        this.studentService.delete(studentDTO.getStudentId());
        return new ModelAndView("redirect:/ui/home");
    }
}
