package com.example.examen_junio_adat.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "toys")
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private Boolean available = true;
    private String bonilla_description; // descripción del juguete
}
