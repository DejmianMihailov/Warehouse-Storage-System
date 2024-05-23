package org.warehouse.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Invoice {
    @Id
    private Long invoiceNumber;

    @Column(nullable = false, columnDefinition = "MONEY")
    private BigDecimal sumPrice;

    @ManyToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @Column(nullable = false)
    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "delivery", nullable = false)
    private Delivery delivery;

    // Getters and setters
}
