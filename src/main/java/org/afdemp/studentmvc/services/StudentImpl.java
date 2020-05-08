/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.services;

import java.util.List;
import org.afdemp.studentmvc.dao.StudentDaoImpl;
import org.afdemp.studentmvc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mac
 */

@Service("studentService")
@Transactional
public class StudentImpl implements IStudent {
    @Autowired
    StudentDaoImpl dao;
    
    @Override
    public List<Student> findAllStudents() {
        List<Student> students = dao.findAllStudents();
        return students;
    }

    public boolean save(Student student) {
        return dao.save(student);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public boolean update(Student student) {
        student.setFirstName(convertTextToUpper(student.getFirstName()));
        student.setLastName(convertTextToUpper(student.getLastName()));
        dao.update(student);
        return true;
    }

    public Student findById(int id) {
        return dao.findById(id);
    }
    
    protected String convertTextToUpper(String text) {
        return text.toUpperCase();
    }
    
}
