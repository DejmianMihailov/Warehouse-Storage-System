package org.warehouse.repository;

import org.warehouse.persistence.Paydesk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaydeskRepository extends JpaRepository<Paydesk, Long> {
}
