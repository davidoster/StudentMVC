/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.dao;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mac
 */
@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements IStudentDao {

    @Override
    public List<Student> findAllStudents() {
        Criteria criteria = createEntityCriteria();
	return (List<Student>) criteria.list();
    }

    public boolean save(Student student) {
        boolean notSaved = persist(student);
        if(notSaved) return false;
        return true;
    }

    public boolean delete(int id) {
        Student s = getByKey(id);
        if(s != null) {
            delete(s);
            if(getByKey(id) == null) 
                return true;
        }
        return false;
    }
    
}
