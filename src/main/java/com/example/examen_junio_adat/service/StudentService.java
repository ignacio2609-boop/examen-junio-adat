package com.example.examen_junio_adat.service;


import com.example.examen_junio_adat.model.Student;
import com.example.examen_junio_adat.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    public StudentRepo studentRepo;

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

    // obtener el número de reservas de un estudiante
    public int getNumberOfBookings(Long studentId) {
        Student student = findById(studentId);
        if (student != null) {
            return student.getBookings().size();
        } else {
            throw new IllegalArgumentException("Student not found.");
        }
    }

}
