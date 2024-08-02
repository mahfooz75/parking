package com.selftechlearner;

import com.selftechlearner.model.Ticket;
import com.selftechlearner.model.Vehicle;
import com.selftechlearner.slot.ParkingSlot;
import com.selftechlearner.slotmanager.ParkingSlotManager;
import com.selftechlearner.slotmanager.ParkingSlotManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class ExitGate {
    private final ParkingSlotManagerFactory parkingSlotManagerFactory;

    public void exitVehicle(Ticket ticket, List<ParkingSlot> slots) {
        Vehicle vehicle = ticket.getVehicle();
        ParkingSlotManager parkingSlotManager = parkingSlotManagerFactory.getParkingSlotManager(vehicle.getVehicleType(), slots);
        parkingSlotManager.removeVehicle(vehicle);
        log.info("Total price: {}", calculatePrice(ticket));
    }

    private double calculatePrice(Ticket ticket) {
        double price = ticket.getParkingSlot().getPrice();
        double exitTime = new Date().getTime();
        double duration = exitTime - ticket.getEntryTime();
        double minutes = duration / 60000;
        return price * minutes;
    }
}
