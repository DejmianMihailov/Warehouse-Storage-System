package org.warehouse.model.request;

import lombok.Data;

@Data
public class EarthquakeRequest {
    private double latitude;
    private double longitude;
    private double radius;
}
