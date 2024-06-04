package org.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.warehouse.model.request.DeliverySearchRequest;
import org.warehouse.model.responce.DeliverySearchResponse;
import org.warehouse.service.DeliveryService;

@RestController
@RequestMapping("/api/vi/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    @PostMapping
    public ResponseEntity<DeliverySearchResponse> searchDeliver(@RequestBody DeliverySearchRequest request){
        return ResponseEntity.ok(deliveryService.serch(request));
    }
}
