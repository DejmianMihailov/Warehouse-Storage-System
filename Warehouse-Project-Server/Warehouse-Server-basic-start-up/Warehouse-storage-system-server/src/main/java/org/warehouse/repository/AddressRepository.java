package org.warehouse.repository;

import org.warehouse.persistence.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByCity(String address);

    Address findAddressById(Long address);
}
