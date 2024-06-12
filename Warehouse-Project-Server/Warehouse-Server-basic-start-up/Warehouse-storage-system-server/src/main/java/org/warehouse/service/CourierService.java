package org.warehouse.service;

import org.warehouse.persistence.Courier;
import org.warehouse.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    public Courier getCourierById(Long id) {
        return courierRepository.findById(id).orElse(null);
    }

    public Courier saveCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}

