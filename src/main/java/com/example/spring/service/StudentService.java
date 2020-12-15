package com.example.spring.service;

import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student findById(Long id){
        return studentRepository.getOne(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deletedById(Long id){
        studentRepository.deleteById(id);
    }
}
