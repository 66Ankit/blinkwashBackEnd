package com.example.blinkwash.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = {
        "https://0380-2405-201-5806-b8dc-6d97-bc0f-a689-a200.ngrok-free.app",
        "https://4581-2405-201-5806-b8dc-6d97-bc0f-a689-a200.ngrok-free.app",
        "https://blinkwashadmin.onrender.com",
        "https://blinkwash.shop",
        "http://blinkwash.shop",
        "http://localhost:3000"
})
public class BillController {


    @Autowired
    private BillService billService;


    @GetMapping
    private List<Bill> getAllBills(){
        return billService.getAllBills();
    }

}
