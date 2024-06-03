package org.warehouse.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.warehouse.model.StockDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class StockResponse {
    List<StockDTO> stock;
}
