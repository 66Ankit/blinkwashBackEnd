package com.example.blinkwash.smsService;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BillRequest {

    private  String mobile;

    private  String name;
    private  String carSegment;
    private  String washType;



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
