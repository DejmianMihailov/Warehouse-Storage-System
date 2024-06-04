package org.warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.model.AddressDTO;
import org.warehouse.model.ClientDTO;
import org.warehouse.model.StockDTO;
import org.warehouse.model.request.DeliverySearchRequest;
import org.warehouse.model.responce.DeliverySearchResponse;
import org.warehouse.persistence.Address;
import org.warehouse.persistence.Client;
import org.warehouse.persistence.Stock;
import org.warehouse.repository.AddressRepository;
import org.warehouse.repository.ClientRepository;
import org.warehouse.repository.DeliveryRepository;
import org.warehouse.repository.StockRepository;

@Service
@Transactional
@ReadingConverter
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final StockRepository stockRepository;

    public DeliverySearchResponse serch(DeliverySearchRequest request) {
        Client client = clientRepository.findClientByName(request.getClientName());
        Address address = addressRepository.findAddressByCity(request.getAddress());
        Long tephone = Long.parseLong(request.getTelephone());
        Stock stock = stockRepository.findStockByName(request.getStock());
        var delivery = deliveryRepository.searchAllByAddressOrClientOrTelephoneOrStock(address.getId(), client.getClientId(), tephone, stock.getStockId()).orElseThrow();
        Client fclient = clientRepository.findClientByClientId(delivery.getClient());
        Address faddress = addressRepository.findAddressById(delivery.getAddress());
        Stock fstock = stockRepository.findStockByStockId(delivery.getStock());
        return new DeliverySearchResponse(
                faddress==null?null:new AddressDTO(faddress.getCity(), faddress.getStreet()),
                fstock==null?null:new StockDTO(fstock.getStockId(), fstock.getName()),
                delivery.getTelephone(),
                fclient==null?null:new ClientDTO(fclient.getName())
        );
    }
}
