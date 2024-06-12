package org.warehouse.controller;

import org.warehouse.persistence.Courier;
import org.warehouse.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public Courier getCourierById(@PathVariable Long id) {
        return courierService.getCourierById(id);
    }

    @PostMapping
    public Courier createCourier(@RequestBody Courier courier) {
        return courierService.saveCourier(courier);
    }

    @DeleteMapping("/{id}")
    public void deleteCourier(@PathVariable Long id) {
        courierService.deleteCourier(id);
    }
}
