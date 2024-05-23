package org.warehouse.repository;

import org.warehouse.persistence.StockDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDeliveryRepository extends JpaRepository<StockDelivery, Long> {
}
