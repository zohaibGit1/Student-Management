package com.zohaib.StudentMngt.Demo.Controller;

import com.zohaib.StudentMngt.Demo.entity.Student;
import com.zohaib.StudentMngt.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createPerson(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/get")
    public List<Student> getData() {
        return studentService.getAllStudentData();
    }

    @GetMapping // Get Student By ID
    public Student getStudentByID(@RequestParam Integer id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentDetails(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    @PatchMapping("/{id}")
    public Student partialUpdateData(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.partiallyUpdate(id,student);
    }

    @DeleteMapping("/{id}")
    public Student deleteById(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.DeleteByID(id, student);
    }
}
