package org.warehouse.repository;

import org.warehouse.persistence.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockByName(String stock);

    Stock findStockByStockId(Long stock);
}
