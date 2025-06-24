package com.example.examen_junio_adat.repository;

import com.example.examen_junio_adat.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepo extends JpaRepository<Toy,Long> {
}
