package com.parking_demo.service;


import com.parking_demo.model.Ticket;

public interface ParkingLotService {

    public String createParkingLot (int capacity);
    public Ticket parkCar(String registrationNumber, String color);
    public String leaveSlot(Ticket ticket);
    public String getStatus();
    public String getRegistrationNumbersByColor(String color);
    public String getSlotNumberByRegistrationNumber(String registrationNumber);
    public String getSlotNumbersByColor(String color);
}
