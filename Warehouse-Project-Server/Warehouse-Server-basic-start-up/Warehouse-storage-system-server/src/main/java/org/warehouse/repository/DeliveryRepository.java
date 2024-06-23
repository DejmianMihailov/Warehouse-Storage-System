package org.warehouse.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.warehouse.persistence.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Query("SELECT u FROM Delivery u WHERE u.address= ?1 OR u.client= ?2 OR u.telephone= ?3 OR u.stock= ?4  order by u.address desc limit 1")
    Optional<Delivery> searchAllByAddressOrClientOrTelephoneOrStock(Long address, Long client, Long telephone, Long stock);

    @Query("SELECT u FROM Delivery u WHERE  u.client= ?1 OR u.telephone= ?2 OR u.stock= ?3  order by u.address desc limit 1")
    Optional<Delivery> searchAllByClientOrTelephoneOrStock(Long clientId, Long tephone, Long stockId);
}
