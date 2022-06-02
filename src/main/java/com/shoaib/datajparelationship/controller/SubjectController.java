package com.shoaib.datajparelationship.controller;

import com.shoaib.datajparelationship.entity.Student;
import com.shoaib.datajparelationship.entity.Subject;
import com.shoaib.datajparelationship.entity.Teacher;
import com.shoaib.datajparelationship.repository.StudentRepository;
import com.shoaib.datajparelationship.repository.SubjectRepository;
import com.shoaib.datajparelationship.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/subjects")
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping("/subjects")
    public Subject createSubjects(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("subjects/{subjectId}/students/{studentId}")
    public Subject enrolledStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.setEnrolledStudents(student);
        return subjectRepository.save(subject);
    }

    @PutMapping("subjects/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
