package com.connectPostgres.demoPostgres.Service;

import com.connectPostgres.demoPostgres.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student SaveStudent(Student student);

    Student GetStudentById(Integer id);

    Student EditStudent(Student student);

    void deleteStudent(Integer id);
}
