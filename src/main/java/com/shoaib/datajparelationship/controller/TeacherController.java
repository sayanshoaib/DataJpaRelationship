package com.shoaib.datajparelationship.controller;

import com.shoaib.datajparelationship.entity.Teacher;
import com.shoaib.datajparelationship.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
