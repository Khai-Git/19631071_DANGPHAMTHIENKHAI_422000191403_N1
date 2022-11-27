package com.StudentService.StudentService.controllers;

import com.StudentService.StudentService.entities.Student;
import com.StudentService.StudentService.services.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"", "/"})
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = {"/{studentId}", "/{studentId}/"})
    @Cacheable(value = "student", key = "#studentId")
    @Retry(name = "student-service", fallbackMethod = "getStudentFallback")
    @CircuitBreaker(name = "student-service", fallbackMethod = "getStudentFallback")
    @RateLimiter(name = "student-service")
    public Student getStudentById(@PathVariable long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = {"", "/"})
    @Retry(name = "student-service", fallbackMethod = "addStudentFallback")
    @CircuitBreaker(name = "student-service", fallbackMethod = "addStudentFallback")
    @RateLimiter(name = "student-service")
    public void addStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @GetMapping(value = {"/email/{email}", "/email/{email}/"})
    @Cacheable(value = "student", key = "#email")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping(value = {"/phone/{phoneNumber}", "/phone/{phoneNumber}/"})
    @Cacheable(value = "student", key = "#phoneNumber")
    public Student getStudentByPhoneNumber(@PathVariable String phoneNumber) {
        return studentService.getStudentByPhoneNumber(phoneNumber);
    }

    public Student getStudentFallback(Exception e) {
        System.out.println("Fallback method called");
        return null;
    }

    public void addStudentFallback(Exception e) {
        System.out.println("Fallback method called");
    }
}