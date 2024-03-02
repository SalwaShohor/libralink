package com.dareshuri.libralink.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Repository.StudentRepo;
import com.dareshuri.libralink.Model.Student;
import com.dareshuri.libralink.Service.StudentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Iterable<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentByUserId(Long userId) {
        return studentRepo.findByUserId(userId);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepo.findById(studentId);
    }

    
}