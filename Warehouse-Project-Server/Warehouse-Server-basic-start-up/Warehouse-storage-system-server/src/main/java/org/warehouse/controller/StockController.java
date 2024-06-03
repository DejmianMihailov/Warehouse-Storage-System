package org.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.warehouse.model.responce.StockResponse;
import org.warehouse.service.StockService;

@RestController
@RequestMapping("/api/vi/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<StockResponse> getAllStock(){
        return ResponseEntity.ok(stockService.getStock());
    }
}
