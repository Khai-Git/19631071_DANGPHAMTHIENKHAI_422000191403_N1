package com.StudentService.StudentService.services;

import com.StudentService.StudentService.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllCustomers();
    Student getStudentByStudentId(long studentid);

    Student getStudentByEmail(String name);

    void createStudent(Student student);

    Student getStudentByMentorId (String mentorid);
}
