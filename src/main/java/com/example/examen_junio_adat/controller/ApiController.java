package com.example.examen_junio_adat.controller;

import com.example.examen_junio_adat.model.Student;
import com.example.examen_junio_adat.model.Toy;
import com.example.examen_junio_adat.service.BookingService;
import com.example.examen_junio_adat.service.StudentService;
import com.example.examen_junio_adat.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class ApiController {
    private final StudentService studentService;
    private final ToyService toyService;
    private final BookingService bookingService;

    public ApiController(StudentService studentService, ToyService toyService, BookingService bookingService) {
        this.studentService = studentService;
        this.toyService = toyService;
        this.bookingService = bookingService;
    }

    @RequestMapping("/demo")
    public String demo() {
        return "Hola Andrei!";
    }


    //Endpoints for Student
    @PostMapping("/alumnos")
    public ResponseEntity<Student> addStudent(Student student) {
        Student newStudent = studentService.saveOrUpdateStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("/alumnos")
    public ResponseEntity<Iterable<Student>> getAllStudents() {
        Iterable<Student> students = studentService.studentRepo.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Student> getStudentById(Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Student> deleteStudent(Long id) {
        Student student = studentService.deleteStudent(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoints for Toy

    @PostMapping("/juguetes")
    public ResponseEntity<Toy> addToy(@RequestBody Toy toy) {
        Toy newToy = toyService.saveOrUpdateToy(toy);
        return ResponseEntity.ok(newToy);
    }

    @GetMapping("/juguetes")
    public  ResponseEntity<Iterable<Toy>> getAllToys() {
        Iterable<Toy> toys = toyService.toyRepo.findAll();
        return ResponseEntity.ok(toys);
    }

    @GetMapping("/juguetes/{id}")
    public ResponseEntity<Toy> getToyById(@PathVariable Long id) {
        Toy toy = toyService.findById(id);
        if (toy != null) {
            return ResponseEntity.ok(toy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/juguetes/{id}")
    public ResponseEntity<Toy> deleteToy(@PathVariable Long id) {
        Toy toy = toyService.deleteToy(id);
        if (toy != null) {
            return ResponseEntity.ok(toy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoints for Booking


}
