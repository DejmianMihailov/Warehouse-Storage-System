package org.warehouse.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Client {
    @Id
    private Long clientId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "client")
    private Set<Invoice> invoices = new LinkedHashSet<>();

}
