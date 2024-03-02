package com.dareshuri.libralink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Service.UserService;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    UserService studentService;
    
}

