package com.zohaib.StudentMngt.Demo.repo;

import com.zohaib.StudentMngt.Demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
