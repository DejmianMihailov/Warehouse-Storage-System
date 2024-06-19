package org.warehouse.repository;

import org.springframework.stereotype.Repository;
import org.warehouse.persistence.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
}
