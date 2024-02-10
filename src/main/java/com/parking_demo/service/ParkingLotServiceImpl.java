package com.parking_demo.service;

import com.parking_demo.model.Car;
import com.parking_demo.model.Ticket;
import com.parking_demo.util.CustomException;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private final Map<Integer, Car> parkingLot = new LinkedHashMap<>();
    private int capacity;


    @Override
    public String createParkingLot(int capacityI) {
        try {
            if(capacityI > 0){
                capacity = capacityI;
                parkingLot.clear();
                return "Created a parking lot with " + capacity + " slots";
            }else{
                return "You must create a parking slot with Positive Integer";
            }

        }catch(CustomException e){
            throw new CustomException("Something went wrong");
        }
    }

    @Override
    public Ticket parkCar(String registrationNumber, String color) {
        if (capacity == 0){
            throw new CustomException("Create a parking lot first");
        }
        if (parkingLot.size() >= capacity) {
             throw new CustomException("Sorry, parking lot is full");
        }
        int availableSlot = findFirstAvailableSlot();
        if(!parkingLot.isEmpty()) {
            if (availableSlot == -1) {
                throw new CustomException("Sorry, parking lot is full");
            }
            for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
                if (entry.getValue().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                    throw new CustomException("Registration number already exist");
                }
            }
        }
        Ticket ticket = new Ticket();
        ticket.setSlot(availableSlot);
        ticket.setCar(new Car(registrationNumber, color));
        parkingLot.put(availableSlot, new Car(registrationNumber, color));
        return ticket;
    }

    @Override
    public String leaveSlot(Ticket ticket) {
        try {
            if (!parkingLot.containsKey(ticket.getSlot())) {
                return "Slot number " + ticket.getSlot() + " is already empty";
            }

            for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
                if (entry.getKey().equals(ticket.getSlot())) {
                    Car car = entry.getValue();
                    if (car.getRegistrationNumber().equals(ticket.getCar().getRegistrationNumber()) &&
                            car.getColor().equals(ticket.getCar().getColor())) {
                        parkingLot.remove(ticket.getSlot());
                        return "Slot number " + ticket.getSlot() + " is free";
                    }
                }
            }
            return "Please check registration number and color on the ticket";
        } catch (CustomException e) {
            throw new CustomException("Something went wrong");
        }
    }


    @Override
    public String getStatus() {
        try {
            StringBuilder status = new StringBuilder("Slot No. Registration No Colour\n");
            for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
                status.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            return status.toString();
        }catch (CustomException e) {
            throw new CustomException("Something went wrong");
        }
    }

    @Override
    public String getRegistrationNumbersByColor(String color) {
        try {
            StringBuilder registrationNumbers = new StringBuilder();
            for (Car car : parkingLot.values()) {
                if (car.getColor().equalsIgnoreCase(color)) {
                    registrationNumbers.append(car.getRegistrationNumber()).append(", ");
                }
            }
            if (!registrationNumbers.isEmpty()) {
                registrationNumbers.deleteCharAt(registrationNumbers.length() - 1);
                registrationNumbers.deleteCharAt(registrationNumbers.length() - 1);
                return registrationNumbers.toString();
            }
            return "Not found, Please check the color";
        }catch (CustomException e){
            throw new CustomException("Something went wrong");
        }

    }

    @Override
    public String getSlotNumberByRegistrationNumber(String registrationNumber) {
        try {
            for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
                if (entry.getValue().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                    return String.valueOf(entry.getKey());
                }
            }
            return "Not found, Please check the RegistrationNumber";
        }catch (CustomException e){
            throw new CustomException("Something went wrong");
        }
    }

    @Override
    public String getSlotNumbersByColor(String color) {
        try {
            StringBuilder slotNumbers = new StringBuilder();
            for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
                if (entry.getValue().getColor().equalsIgnoreCase(color)) {
                    slotNumbers.append(entry.getKey()).append(", ");
                }
            }
            if (!slotNumbers.isEmpty()) {
                slotNumbers.deleteCharAt(slotNumbers.length() - 1);
                slotNumbers.deleteCharAt(slotNumbers.length() - 1);
                return slotNumbers.toString();
            }
            return "Not found, Please check the color";
        }catch (CustomException e){
            throw new CustomException("Something went wrong");
        }
    }
    private int findFirstAvailableSlot() {
        for (int slot = 1; slot <= capacity; slot++) {
            if (!parkingLot.containsKey(slot)) {
                return slot;
            }
        }
        return -1;
    }
}
