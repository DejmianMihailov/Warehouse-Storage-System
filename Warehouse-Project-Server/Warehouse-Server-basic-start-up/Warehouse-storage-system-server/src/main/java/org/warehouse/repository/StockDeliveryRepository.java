package org.warehouse.repository;

import org.springframework.stereotype.Repository;
import org.warehouse.persistence.StockDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface StockDeliveryRepository extends JpaRepository<StockDelivery, Long> {
}
