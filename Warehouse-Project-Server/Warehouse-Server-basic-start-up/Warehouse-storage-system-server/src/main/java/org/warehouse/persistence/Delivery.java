package org.warehouse.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Delivery {
    @Id
    private Long deliveryId;

    @Column(nullable = false)
    private Long address;

    @Column(nullable = false)
    private Long stock;

    @Column(nullable = false)
    private Long telephone;

    @Column(nullable = false)
    private Long courier;

    @Column(nullable = false)
    private Long client;

    // Getters and setters
}
