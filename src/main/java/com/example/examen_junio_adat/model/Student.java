package com.example.examen_junio_adat.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String surname;
    private String irbj_grade; //curso
    private String irbj_email; //email
}
