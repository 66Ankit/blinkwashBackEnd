package com.example.blinkwash.smsService;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class SmsService {


    private final Map<String, Map<String, Double>> pricing;

    @Autowired
    private TwilioConfig twilioConfig;

    @Value("${twilio.messaging.service.sid}")
    private String messagingServiceSid;

    // Dummy prices for services
    private final double HATCHBACK_WASH_PRICE = 300;
    private final double SEDAN_WASH_PRICE = 400;
    private final double SUV_WASH_PRICE = 500;
    private final double LUXURY_WASH_PRICE = 700;

    public SmsService(Map<String, Map<String, Double>> pricing) {
        this.pricing = pricing;
    }

    public String sendBillSMS(BillRequest billRequest) {
        // Ensure phone number is in E.164 format
        String mobile = billRequest.getMobile();
        if (!mobile.startsWith("+")) {
            mobile = "+91" + mobile; // Assuming Indian numbers
        }

        // Calculate price based on car segment and wash type
        double price = calculatePrice(billRequest.getCarSegment(), billRequest.getWashType());

        // Generate the bill message
        String messageBody = generateBillMessage(billRequest, price);

        // Send the message using Twilio
        Message message = Message.creator(
                new PhoneNumber(mobile),
                messagingServiceSid, // Messaging Service ID
                messageBody
        ).create();

        return "Message sent with SID: " + message.getSid();
    }

private double calculatePrice(String carSegment, String washType) {
    return pricing.getOrDefault(carSegment, Map.of()).getOrDefault(washType, 0.0);
}
    private String generateBillMessage(BillRequest request, double price) {
        return String.format(
                "Hello %s,\n" +
                        "Thank you for using BlinkWash!\n\n" +
                        "Car Segment: %s\n" +
                        "Wash Type: %s\n" +
                        "Bill Date: %s\n" +
                        "Total Amount: ₹%.2f\n\n" +
                        "We hope to see you again!",
                request.getName(),
                request.getCarSegment(),
                request.getWashType(),
                getCurrentDate(), // Format date for readability
                price
        );
    }

    private String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
