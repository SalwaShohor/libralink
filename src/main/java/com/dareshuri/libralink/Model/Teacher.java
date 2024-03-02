package com.dareshuri.libralink.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    @NotBlank
    private Long userId;
    @NotBlank
    private Long departmentId;


    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getTeacherId(Long teacherId){
        return teacherId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}
