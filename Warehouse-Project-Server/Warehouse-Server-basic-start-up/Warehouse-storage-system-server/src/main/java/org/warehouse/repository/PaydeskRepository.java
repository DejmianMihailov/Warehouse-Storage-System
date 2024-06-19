package org.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.warehouse.persistence.Paydesk;

public interface PaydeskRepository extends JpaRepository<Paydesk, Long> {
}
