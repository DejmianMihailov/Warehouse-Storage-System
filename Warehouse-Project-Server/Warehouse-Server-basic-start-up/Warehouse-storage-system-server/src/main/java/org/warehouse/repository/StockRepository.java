package org.warehouse.repository;

import org.springframework.stereotype.Repository;
import org.warehouse.persistence.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockByName(String stock);

    Stock findStockByStockId(Long stock);
}
