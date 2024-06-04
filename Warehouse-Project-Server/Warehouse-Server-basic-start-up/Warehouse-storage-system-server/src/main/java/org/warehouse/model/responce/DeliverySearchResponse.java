package org.warehouse.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.warehouse.model.AddressDTO;
import org.warehouse.model.ClientDTO;
import org.warehouse.model.StockDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverySearchResponse {
    private AddressDTO address;
    private StockDTO stock;
    private Long telephone;
    private ClientDTO client;
}
