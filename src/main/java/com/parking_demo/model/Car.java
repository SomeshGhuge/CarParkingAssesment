package com.parking_demo.model;

import com.parking_demo.util.CustomException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {

    private String registrationNumber;
    private String color;

    public Car(String registrationNumber, String color) {
        if(!registrationNumber.isEmpty() && !color.isEmpty()) {
            if (validateRegistrationNumber(registrationNumber)) {
                this.registrationNumber = registrationNumber;
            } else {
                throw new CustomException("Please enter a valid registration number like MH-01-AB-1234");
            }
            this.color = color;
        }else {
            throw new CustomException("Please enter registration number and color both");
        }
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    private boolean validateRegistrationNumber(String regNumber) {
        String pattern = "^[A-Z]{2}-\\d{2}-[A-Z]{2}-\\d{4}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(regNumber);
        return matcher.matches();
    }
}
