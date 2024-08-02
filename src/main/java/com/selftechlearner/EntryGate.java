package com.selftechlearner;

import com.selftechlearner.model.Ticket;
import com.selftechlearner.model.Vehicle;
import com.selftechlearner.slot.ParkingSlot;
import com.selftechlearner.slotmanager.ParkingSlotManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class EntryGate {
    private final ParkingSlotManagerFactory parkingSlotManagerFactory;

    public ParkingSlot parkVehicle(Vehicle vehicle, List<ParkingSlot> slots) {
        return parkingSlotManagerFactory.getParkingSlotManager(vehicle.getVehicleType(), slots)
                .parkVehicle(vehicle);
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        return Ticket.builder()
                .ticketId(UUID.randomUUID().toString())
                .entryTime(new Date().getTime())
                .vehicle(vehicle)
                .parkingSlot(parkingSlot)
                .build();
    }
}
