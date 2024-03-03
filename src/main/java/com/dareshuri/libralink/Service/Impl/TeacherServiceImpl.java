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

    // ADD
    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    // UPDATE
    @Override
    public Teacher updateDepartmentIdById(Long id, Long departmentId) {
        Optional<Teacher> existingTeacher = teacherRepo.findById(id);

        if (existingTeacher.isPresent()) {
            Teacher teacherToUpdate = existingTeacher.get();
            teacherToUpdate.setDepartmentId(departmentId);
            return teacherRepo.save(teacherToUpdate);

        } else {
            return null;
        }
    }

    // DELETE
    @Override
    public String deleteTeacherById(Long id) {

        Optional<Teacher> teacherOptional = teacherRepo.findById(id);

        if(teacherOptional.isPresent()){
            Teacher teacherToDelete = teacherOptional.get();
            teacherRepo.delete(teacherToDelete);
            return String.format("Teacher with id %d successfully deleted!",id);
        }
        
        return String.format("Teacher with id %d is not found!",id);
    }

}
