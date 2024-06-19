package org.warehouse.repository;

import org.springframework.stereotype.Repository;
import org.warehouse.persistence.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
