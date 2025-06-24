package com.example.examen_junio_adat.service;

import com.example.examen_junio_adat.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService{
    @Autowired
    private BookingRepo bookingRepo;
}
