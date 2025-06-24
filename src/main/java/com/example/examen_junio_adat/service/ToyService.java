package com.example.examen_junio_adat.service;

import com.example.examen_junio_adat.model.Toy;
import com.example.examen_junio_adat.repository.ToyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
