package org.warehouse.repository;

import org.warehouse.persistence.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByName(String clientName);

    Client findClientByClientId(Long client);
}
