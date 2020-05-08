/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.dao;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;

/**
 *
 * @author mac
 */
public interface IStudentDao {
    public List<Student> findAllStudents();
    public Student findById(int id);
    public boolean save(Student student);
    public boolean delete(int id);
    public boolean update(Student student);
    
}
