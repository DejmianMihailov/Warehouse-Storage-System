package org.warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.model.PaydeskDTO;
import org.warehouse.persistence.Paydesk;
import org.warehouse.repository.PaydeskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@ReadingConverter
public class PaydeskService {

    @Autowired
    private final PaydeskRepository paydeskRepository;


    public List<PaydeskDTO> getAllPaydesks() {
        List<PaydeskDTO> foundPaydesks = new ArrayList<>();
        paydeskRepository.findAll().forEach(paydesk -> foundPaydesks.add(new PaydeskDTO(paydesk.getId(), paydesk.getTimestamp(), paydesk.getUpdateCounter(), paydesk.getMoney())));
        return foundPaydesks;
    }

    public Paydesk getPaydeskById(Long id) {
        return paydeskRepository.findById(id).orElse(null);
    }

    public Paydesk savePaydesk(Paydesk paydesk) {
        return paydeskRepository.save(paydesk);
    }

    public void deletePaydesk(Long id) {
        paydeskRepository.deleteById(id);
    }
}
