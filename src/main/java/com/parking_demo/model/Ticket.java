package com.parking_demo.model;

public class Ticket {
    private int slot;
    private Car car;

    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getSlot() {
        return slot;
    }

    public Ticket() {
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "slot=" + slot +
                ", car=" + car +
                '}';
    }
}
