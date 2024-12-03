package com.zohaib.StudentMngt.Demo.service;

import com.zohaib.StudentMngt.Demo.entity.Student;
import com.zohaib.StudentMngt.Demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentrepo;

    public Student createStudent(Student student) {
        return studentrepo.save(student);
    }

    public List<Student> getAllStudentData() {
        return studentrepo.findAll();
    }

    public Student getStudentById(Integer id) {
        Optional<Student> byId = studentrepo.findById(id);
        return byId.get();
    }

    // Update logic
    public Student updateStudentById(Integer id, Student student) {
        Student std = null;
        Optional<Student> studentID = studentrepo.findById(id);
        if (studentID.isPresent()) {
            Student student1 = studentID.get();
            student1.setAge(student.getAge());
            student1.setEducation(student.getEducation());
            student1.setName(student.getName());
            std = studentrepo.save(student1);
        } else {
            System.out.println("Data Not Found");
        }
        return std;
    }

    // Partial Updated Logic
    public Student partiallyUpdate(Integer id, Student student) {
        Student updatedStudent = null;
        Optional<Student> dbStudent = studentrepo.findById(id);

        if (dbStudent.isPresent()) {
            Student student2 = dbStudent.get();
            if (student.getEducation() != null) {
                student2.setEducation(student.getEducation());
            }
            if (student.getName() != null) {
                student2.setName(student.getName());
            }
            updatedStudent = studentrepo.save(student2);
        } else {
            System.out.println("Data not Found");
        }
        return updatedStudent;
    }

    public Student DeleteByID(Integer id, Student student) {
        Optional<Student> studentOptional = studentrepo.findById(id);
        if (studentOptional.isPresent()) {
            Student stdDelete = studentOptional.get();
            studentrepo.deleteById(id);
            return student;
        }else {
            System.out.println("Student with " + id + " not Found");
        }
        return null;
    }
}
