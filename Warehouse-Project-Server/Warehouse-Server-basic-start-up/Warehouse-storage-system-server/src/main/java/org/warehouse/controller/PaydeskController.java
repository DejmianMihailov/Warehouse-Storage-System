package org.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.warehouse.model.PaydeskDTO;
import org.warehouse.persistence.Paydesk;
import org.warehouse.service.PaydeskService;

import java.util.List;

@RestController
@RequestMapping("/api/vi/paydesks")
public class PaydeskController {

    @Autowired
    private PaydeskService paydeskService;

    @GetMapping
    public ResponseEntity<List<PaydeskDTO>> getAllPaydesks() {
        return ResponseEntity.ok().body(paydeskService.getAllPaydesks());
    }

    @GetMapping("/{id}")
    public Paydesk getPaydeskById(@PathVariable Long id) {
        return paydeskService.getPaydeskById(id);
    }

    @PostMapping
    public Paydesk createPaydesk(@RequestBody Paydesk paydesk) {
        return paydeskService.savePaydesk(paydesk);
    }

    @DeleteMapping("/{id}")
    public void deletePaydesk(@PathVariable Long id) {
        paydeskService.deletePaydesk(id);
    }
}
