package org.warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.model.StockDTO;
import org.warehouse.model.responce.StockResponse;
import org.warehouse.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@ReadingConverter
public class StockService {
    private final StockRepository stockRepository;

    public StockResponse getStock() {
        var stock= stockRepository.findAll();
        List<StockDTO> stockResponses= new ArrayList<>();
        stock.forEach(stock1 -> stockResponses.add(new StockDTO(stock1.getStockId(),stock1.getName())));
        return new StockResponse(stockResponses);
    }
}
