package com.dareshuri.libralink.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Teacher;
import com.dareshuri.libralink.Repository.TeacherRepo;
import com.dareshuri.libralink.Service.TeacherService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired 
    TeacherRepo teacherRepo;

    // READ
    @Override
    public Iterable<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherByUserId(Long id) {
        return teacherRepo.findByUserId(id);
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepo.findById(id);
    }

    // CREATE
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    // UPDATE
    @Override
    public void updateTeacher(Long id, Teacher updatedTeacher) {
        Optional<Teacher> existingTeacher = teacherRepo.findById(id);
        
        if (existingTeacher.isPresent()) {
            Teacher teacherToUpdate = existingTeacher.get();
            teacherToUpdate.setUserId(updatedTeacher.getUserId());
            teacherToUpdate.setDepartmentId(updatedTeacher.getDepartmentId());
            
            // Add any other fields you want to update
            
            teacherRepo.save(teacherToUpdate);
        } else {
            // Handle the case where the teacher with the given id doesn't exist
            // You can throw an exception or handle it based on your requirements
        }
    }

    // DELETE
    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }


    
}
