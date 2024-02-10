package com.parking_demo.controller;

import com.parking_demo.model.Car;
import com.parking_demo.model.Ticket;
import com.parking_demo.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car_parking")
public class ParkingLotController {

        @Autowired
        private ParkingLotService parkingLotService;
        @PostMapping("/parking_lot_size/{capacity}")
        public String createParkingLot(@PathVariable int capacity) {
          return parkingLotService.createParkingLot(capacity);
        }

        @PostMapping("/car_park")
        public Ticket parkCar(@RequestBody Car car) {
            return parkingLotService.parkCar(car.getRegistrationNumber(),car.getColor());
        }

        @PostMapping("/car_leave")
        public String leaveSlot(@RequestBody Ticket ticket) {
            return parkingLotService.leaveSlot(ticket);
        }

        @GetMapping("/parking_status")
        public String getStatus() {
             return parkingLotService.getStatus();
        }

        @GetMapping("/find_registration_number_from_color")
        public String getRegistrationNumbersByColor(@RequestParam("color") String color) {
            return parkingLotService.getRegistrationNumbersByColor(color);
        }

        @GetMapping("/find_slot_number_from_registration_number")
        public String getSlotNumberByRegistrationNumber(@RequestParam("registrationNumber") String registrationNumber) {
            return parkingLotService.getSlotNumberByRegistrationNumber(registrationNumber);
        }

        @GetMapping("/find_slot_number_from_color")
        public String getSlotNumbersByColor(@RequestParam("color") String color) {
            return parkingLotService.getSlotNumbersByColor(color);
        }

}
