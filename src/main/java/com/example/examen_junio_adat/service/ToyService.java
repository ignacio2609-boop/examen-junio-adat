package com.example.examen_junio_adat.service;

import com.example.examen_junio_adat.model.Toy;
import com.example.examen_junio_adat.repository.ToyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToyService {
    @Autowired
    public ToyRepo toyRepo;

    public Toy saveOrUpdateToy(Toy toy) {
        return toyRepo.save(toy);
    }

    public Toy findById(Long id) {
        return toyRepo.findById(id).orElse(null);
    }

    public Toy deleteToy(Long id) {
        Toy toy = findById(id);
        if (toy != null) {
            toyRepo.delete(toy);
        }
        return toy;
    }

    // Obtener juguetes disponibles para reservar
    public List<Toy> getAvailableToys() {
        return toyRepo.findAll().stream()
                .filter(Toy::isAvailable)
                .collect(Collectors.toList());
    }
}
