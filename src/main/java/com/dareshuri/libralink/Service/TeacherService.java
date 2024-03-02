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


    // CREATE
    Teacher saveTeacher(Teacher teacher);

    // UPDATE
    void updateTeacher(Long id, Teacher updatedTeacher);

    // DELETE
    void deleteTeacher(Long id);
    
}
