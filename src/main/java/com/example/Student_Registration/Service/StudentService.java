package com.example.Student_Registration.Service;

import com.example.Student_Registration.Repository.StudentRepository;
import com.example.Student_Registration.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student){
        String Email = student.getEmail();
        if(studentRepository.existsByEmail(Email)) {
            throw new IllegalArgumentException("Student with same email already exists.");
        }
        else {
            return studentRepository.save(student);
        }
    }

    public List<Student> GetAll(){
        return studentRepository.findAll();
    }

    public List<Student> GetAllByName(){
        return studentRepository.findAllByOrderByNameAsc();
    }


    public Optional<Student> GetById(int id){
        if(studentRepository.existsById(id)){
            return studentRepository.findById(id);
        }
        else {
            throw new NullPointerException("Student not Found!!");
        }
    }

    public String DeleteById(int id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            studentRepository.deleteById(id);
            return student.get().getName()+"Has been successfully removed!!";
        }else{
            throw new NullPointerException("Student Not Found");
        }
    }

    public String Update(int id,String newName,String newEmail,String newAddress){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            Student newStudent = student.get();
            newStudent.setName(newName);
            newStudent.setEmail(newEmail);
            newStudent.setAddress(newAddress);
            studentRepository.save(newStudent);
            return newName+"Updated Successfully!!";
        }else throw new IllegalArgumentException("No Student found with Id:"+id);
    }

}
