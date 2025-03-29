package com.example.blinkwash.smsService;

import com.example.blinkwash.mongo.Bill;
import com.example.blinkwash.mongo.BillService;
import com.example.blinkwash.smsService.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {
        "https://0380-2405-201-5806-b8dc-6d97-bc0f-a689-a200.ngrok-free.app",
        "https://4581-2405-201-5806-b8dc-6d97-bc0f-a689-a200.ngrok-free.app",
        "https://blinkwashadmin.onrender.com",
        "https://blinkwash.shop",
        "http://blinkwash.shop",
        "http://localhost:3000"
})
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private BillService billService;

    @PostMapping("/send")
    public String sendBillSms(@RequestBody BillRequest billRequest) {

        Bill newBill= new Bill();

//        newBill.setId();
        newBill.setName(billRequest.getName());
        newBill.setCarSegment(billRequest.getCarSegment());
        newBill.setMobile(billRequest.getMobile());
        newBill.setWashType(billRequest.getWashType());
        newBill.setAmount(billService.calculatePrice(billRequest.getCarSegment(),billRequest.getWashType()));
        billService.saveBill(newBill);
        return smsService.sendBillSMS(billRequest);
    }
}
