package com.parking_demo.controller;

import com.parking_demo.model.Car;
import com.parking_demo.model.Ticket;
import com.parking_demo.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking_slot")
public class ParkingLotController {

        @Autowired
        private ParkingLotService parkingLotService;
        @PostMapping("/create_parking_lot/{capacity}")
        public String createParkingLot(@PathVariable int capacity) {
          return parkingLotService.createParkingLot(capacity);
        }

        @PostMapping("/park")
        public Ticket parkCar(@RequestBody Car car) {
            return parkingLotService.parkCar(car.getRegistrationNumber(),car.getColor());
        }

        @PostMapping("/leave")
        public String leaveSlot(@RequestBody Ticket ticket) {
            return parkingLotService.leaveSlot(ticket);
        }

        @GetMapping("/status")
        public String getStatus() {
             return parkingLotService.getStatus();
        }

        @GetMapping("/registration_numbers_for_cars_with_colour")
        public String getRegistrationNumbersByColor(@RequestParam("color") String color) {
            return parkingLotService.getRegistrationNumbersByColor(color);
        }

        @GetMapping("/slot_number_for_registration_number")
        public String getSlotNumberByRegistrationNumber(@RequestParam("registrationNumber") String registrationNumber) {
            return parkingLotService.getSlotNumberByRegistrationNumber(registrationNumber);
        }

        @GetMapping("/slot_numbers_for_cars_with_colour")
        public String getSlotNumbersByColor(@RequestParam("color") String color) {
            return parkingLotService.getSlotNumbersByColor(color);
        }

}
