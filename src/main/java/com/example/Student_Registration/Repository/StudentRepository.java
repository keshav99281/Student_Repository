package com.example.Student_Registration.Repository;

import com.example.Student_Registration.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    boolean existsByEmail(String email);

    List<Student> findAllByOrderByNameAsc();
}
