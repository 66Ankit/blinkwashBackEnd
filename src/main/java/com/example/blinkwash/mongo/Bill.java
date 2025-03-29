package com.example.blinkwash.mongo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Document(collection = "bills")
public class Bill {

    @Id
    private String id;


    private String name;
    private String mobile;
    private String carSegment;
    private String washType;

    private String date;
    private double amount;





    public Bill() {
        this.id = UUID.randomUUID().toString(); // Generate random ID
        this.date = new SimpleDateFormat("ddMMyyyy").format(new Date());
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCarSegment() {
        return carSegment;
    }

    public void setCarSegment(String carSegment) {
        this.carSegment = carSegment;
    }

    public String getWashType() {
        return washType;
    }

    public void setWashType(String washType) {
        this.washType = washType;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public double getAmount() { // Getter for amount
        return amount;
    }

    public void setAmount(double amount) { // Setter for amount
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", carSegment='" + carSegment + '\'' +
                ", washType='" + washType + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
