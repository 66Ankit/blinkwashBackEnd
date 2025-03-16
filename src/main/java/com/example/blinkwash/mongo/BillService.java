package com.example.blinkwash.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepository;

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }
}
