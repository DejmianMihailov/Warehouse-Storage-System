package org.warehouse.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StockHistory {
    @Id
    private Long id;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false)
    private Long updateCounter;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(columnDefinition = "MONEY", nullable = false)
    private Double supplierPrice;

    @Column(columnDefinition = "MONEY", nullable = false)
    private Double sellPrice;

    @Column(nullable = false)
    private Long user;

    // Getters and setters
}
