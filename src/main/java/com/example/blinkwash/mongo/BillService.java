package com.example.blinkwash.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BillService {


    private final Map<String, Map<String, Double>> pricing;
    @Autowired
    private BillRepo billRepository;

    public BillService(Map<String, Map<String, Double>> pricing) {
        this.pricing = pricing;
    }

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    // Fetch all bills
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public double calculatePrice(String carSegment, String washType) {
        return pricing.getOrDefault(carSegment, Map.of()).getOrDefault(washType, 0.0);
    }
}
