/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.services;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;

/**
 *
 * @author mac
 */
public interface IStudent {
    public List<Student> findAllStudents();
    
}
