package com.example.examen_junio_adat.service;


import com.example.examen_junio_adat.model.Student;
import com.example.examen_junio_adat.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student saveOrUpdateStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student deleteStudent(Long id) {
        Student student = findById(id);
        if (student != null) {
            studentRepo.delete(student);
        }
        return student;
    }


}
