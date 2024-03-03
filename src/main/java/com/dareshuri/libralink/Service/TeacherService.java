package com.dareshuri.libralink.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Teacher;

@Service()
public interface TeacherService {

    // READ
    Iterable<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherByUserId(Long id);
    Optional<Teacher> getTeacherById(Long id);


    // ADD
    Teacher addTeacher(Teacher teacher); //kiv

    // UPDATE
    Teacher updateDepartmentIdById(Long id, Long departmentId);

    // DELETE
    String deleteTeacherById(Long id);
    
}
