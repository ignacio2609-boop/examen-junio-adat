package com.example.examen_junio_adat.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student studentId;
    @ManyToOne
    private Toy toyId;
    @Column
    private LocalDateTime bookingDate;
    private LocalDateTime returnDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    enum Status {
        RESERVED,
        RETURNED
    }

    @Column
    private String ignacio_comments; // comentarios del usuario
    private String ignacio_like; // si le gusta el juguete o no

}
