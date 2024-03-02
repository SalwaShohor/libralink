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

    //CREATE
    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    //READ
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

    //UPDATE
    @Override
    public Student updateGradeByUserId(Long userId, String grade) {
        Optional<Student> studentOptional = studentRepo.findByUserId(userId);
        
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setGrade(grade);
            return studentRepo.save(student);
        }

        return null;
    }

    //DELETE
    @Override
    public String deleteGradeByUserId(Long userId) {
        Optional<Student> studentOptional = studentRepo.findByUserId(userId);
        
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            studentRepo.delete(student);
            return String.format("User with id %d successfully deleted!", userId);
        }

        return String.format("User with id %d not found!", userId);
    }

}