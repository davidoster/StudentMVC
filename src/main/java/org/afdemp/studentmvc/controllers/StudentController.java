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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    private String updateurl = "update";
    
    @Autowired
    IStudent studentService;
    
    @Autowired
    MessageSource messageSource;
    
    // index
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAllStudents(ModelMap view, @RequestParam(required = false) String msg) {
        List<Student> students  = studentService.findAllStudents();
        view.addAttribute("students", students);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return("studentlist");
    }
    
    // get form for new student
    @RequestMapping("/new")
    public String newStudent(ModelMap view) {
        Student student = new Student();
        view.addAttribute("student", student);
        view.addAttribute("listurl", listurl);
        return("newstudent");
    }
    
    // post form for new student
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveStudent(ModelMap view, Student student) {
        if(studentService.save(student)) {
            view.addAttribute("message", new String("All good!"));
        }
        else {
            view.addAttribute("message", new String("All wrong!"));
        }
        view.addAttribute("listurl", listurl);
        return("newstudent");
    }
    
    // delete for an existing student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(ModelMap view, @PathVariable int id) {
        if(studentService.delete(id)) {
            view.addAttribute("msg", new String("Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Not Deleted!"));
        }
        return("redirect:/list");
    }
    
    // show edit / update for an existing student
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editStudent(ModelMap view, @PathVariable int id) {
        Student student = studentService.findById(id);
        view.addAttribute("student", student);
        view.addAttribute("updateurl", updateurl);
        return("editstudent");
    }
    
    // store edit / update for an existing student
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(ModelMap view, Student student) {
        studentService.update(student);
        view.addAttribute("msg", new String(""));
        return("redirect:/list");
    }
    
}
