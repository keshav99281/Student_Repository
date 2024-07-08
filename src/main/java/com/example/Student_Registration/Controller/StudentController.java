package com.example.Student_Registration.Controller;

import com.example.Student_Registration.Service.StudentService;
import com.example.Student_Registration.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/Register")
    public Student Register(@RequestBody Student student){
        return studentService.register(student);
    }

    @GetMapping("/getAll")
    public List<Student> GetAllStudents(){
        return studentService.GetAll();
    }

    @GetMapping("/getByName")
    public List<Student> GetByName(){
        return studentService.GetAllByName();
    }


    @GetMapping("/getStudent/{id}")
    public Optional<Student> GetStudent(@PathVariable int id){
        return studentService.GetById(id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String DeleteStudent(@PathVariable int id){
        return studentService.DeleteById(id);
    }

    @PutMapping("/update/{id}")
    public String UpdateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.Update(id,student.getName(),student.getEmail(),student.getAddress());
    }

}
