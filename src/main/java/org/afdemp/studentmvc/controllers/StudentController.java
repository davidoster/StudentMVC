/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.controllers;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;
import org.afdemp.studentmvc.services.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mac
 */
@Controller
@RequestMapping("/")
public class StudentController {
    private String listurl = "list";
    private String editurl = "edit";
    private String deleteurl = "delete";
    
    @Autowired
    IStudent studentService;
    
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAllStudents(ModelMap view) {
        List<Student> students  = studentService.findAllStudents();
        view.addAttribute("students", students);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        return("studentlist");
    }
    
    // get form for new student
    @RequestMapping("/new")
    public String newStudent(ModelMap view) {
        Student student = new Student();
        view.addAttribute("student", student);
        view.addAttribute("listurl", listurl);
        return "newstudent";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveStudent(ModelMap view, Student student) {
        if(studentService.save(student)) {
            view.addAttribute("message", new String("All good!"));
        }
        else {
            view.addAttribute("message", new String("All wrong!"));
        }
        view.addAttribute("listurl", listurl);
        return "newstudent";
    }
    
    
    
}
