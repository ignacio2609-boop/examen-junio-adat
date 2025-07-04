package com.example.examen_junio_adat.service;

import com.example.examen_junio_adat.model.Booking;
import com.example.examen_junio_adat.model.Toy;
import com.example.examen_junio_adat.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService{
    @Autowired
    private BookingRepo bookingRepo;

    // Reservar un jueguete verificando que no esté reservado

    public Booking saveBooking(Booking booking, ToyService toyService){
        Toy toy = toyService.findById(booking.getId());
        if(toy != null && !toy.isAvailable()) {
            toy.setAvailable(true);
            toyService.saveOrUpdateToy(toy);
            return bookingRepo.save(booking);
        } else {
            throw new IllegalArgumentException("Toy is already reserved or does not exist.");
        }
    }

    // Devolver un juguete y marcarlo como disponible

    public Booking findById(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }

    public Booking returnToy(Long id, ToyService toyService) {
        Booking booking = findById(id);
        if (booking != null) {
            Toy toy = toyService.findById(booking.getId());
            if (toy != null) {
                toy.setAvailable(true);
                toyService.saveOrUpdateToy(toy);
                bookingRepo.delete(booking);
                return booking;
            } else {
                throw new IllegalArgumentException("Toy not found.");
            }
        } else {
            throw new IllegalArgumentException("Booking not found.");
        }
    }
}
