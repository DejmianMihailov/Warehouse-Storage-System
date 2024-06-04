package org.warehouse.model.request;

import lombok.Data;

@Data
public class DeliverySearchRequest {
    private String clientName;
    private String address;
    private String stock;
    private String telephone;
}
