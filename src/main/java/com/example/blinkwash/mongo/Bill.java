package com.example.blinkwash.mongo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "bills")
public class Bill {

    @Id
    private String id;


    private String name;
    private String mobile;
    private String carSegment;
    private String washType;


    public Bill() {
        this.id = UUID.randomUUID().toString(); // Generate random ID
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
}
