package com.example.examen_junio_adat.controller;

import com.example.examen_junio_adat.service.BookingService;
import com.example.examen_junio_adat.service.StudentService;
import com.example.examen_junio_adat.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "Hola API";
    }

    // Aquí puedes agregar más endpoints según sea necesario
}
