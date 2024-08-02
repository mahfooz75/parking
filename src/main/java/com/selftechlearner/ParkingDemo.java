package com.selftechlearner;

import com.selftechlearner.exception.ParkingSlotNotSupported;
import com.selftechlearner.model.ParkingSlotDetails;
import com.selftechlearner.model.Ticket;
import com.selftechlearner.model.Vehicle;
import com.selftechlearner.parkingenum.ParkingSlotTypeEnum;
import com.selftechlearner.parkingenum.VehicleTypeEnum;
import com.selftechlearner.slot.ParkingSlot;
import com.selftechlearner.slotmanager.ParkingSlotManagerFactory;
import com.selftechlearner.util.ParkingUtility;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ParkingDemo {
    public static void main(String[] args) {
        ParkingSlotManagerFactory parkingSlotManagerFactory = new ParkingSlotManagerFactory();
        EntryGate entryGate = new EntryGate(parkingSlotManagerFactory);
        ExitGate exitGate = new ExitGate(parkingSlotManagerFactory);
        // TWO WHEELER DEMO
        final List<Ticket> twoWheelerTickets = new ArrayList<>();
        ParkingSlotDetails twoWheelerParkingSlotDetails = ParkingSlotDetails.builder()
                .floors(List.of(1))
                .rows(List.of(1))
                .cols(List.of(1, 2, 3))
                .type(ParkingSlotTypeEnum.TWO_WHEELER_PARKING_SLOT)
                .build();
        List<ParkingSlot> twoWheelerParkingSlots = new ParkingSpace(twoWheelerParkingSlotDetails).getParkingSlots();
        for (int i = 1; i <= 4; i++) {
            Vehicle vehicle = Vehicle.builder()
                    .vehicleId(String.valueOf(i))
                    .vehicleType(VehicleTypeEnum.TWO_WHEELER)
                    .build();
            if (!VehicleTypeEnum.TWO_WHEELER.equals(vehicle.getVehicleType())) {
                throw new ParkingSlotNotSupported("This slot is only supported for two wheelers vehicles");
            }
            ParkingSlot parkingSlot = entryGate.parkVehicle(vehicle, twoWheelerParkingSlots);
            Ticket ticket = entryGate.generateTicket(vehicle, parkingSlot);
            twoWheelerTickets.add(ticket);
            printTicket(ticket, twoWheelerParkingSlots);
        }
        twoWheelerTickets.forEach(t -> {
            exitGate.exitVehicle(t, twoWheelerParkingSlots);
            printTicket(t, twoWheelerParkingSlots);
        });
        // FOUR WHEELER DEMO
        final List<Ticket> fourWheelerTickets = new ArrayList<>();
        ParkingSlotDetails fourWheelerParkingSlotDetails = ParkingSlotDetails.builder()
                .floors(List.of(1))
                .rows(List.of(1))
                .cols(List.of(4, 5, 6))
                .type(ParkingSlotTypeEnum.FOUR_WHEELER_PARKING_SLOT)
                .build();
        List<ParkingSlot> fourWheelerParkingSlots = new ParkingSpace(fourWheelerParkingSlotDetails).getParkingSlots();
        for (int i = 1; i <= 3; i++) {
            Vehicle vehicle = Vehicle.builder()
                    .vehicleId(String.valueOf(i * 4))
                    .vehicleType(VehicleTypeEnum.FOUR_WHEELER)
                    .build();
            if (!VehicleTypeEnum.FOUR_WHEELER.equals(vehicle.getVehicleType())) {
                throw new ParkingSlotNotSupported("This slot is only supported for four wheelers vehicles");
            }
            ParkingSlot parkingSlot = entryGate.parkVehicle(vehicle, fourWheelerParkingSlots);
            Ticket ticket = entryGate.generateTicket(vehicle, parkingSlot);
            fourWheelerTickets.add(ticket);
            printTicket(ticket, fourWheelerParkingSlots);
        }
        fourWheelerTickets.forEach(t -> {
            exitGate.exitVehicle(t, fourWheelerParkingSlots);
            printTicket(t, fourWheelerParkingSlots);
        });

    }

    private static void printTicket(Ticket ticket, List<ParkingSlot> parkingSlots) {
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        Vehicle vehicle = ticket.getVehicle();
        StringBuilder builder = new StringBuilder();
        builder.append("Ticket Id: ").append(ticket.getTicketId());
        builder.append("\n");
        builder.append("Parking Id: ").append(parkingSlot.getParkingId());
        builder.append("\n");
        builder.append("Parking Slot Type: ").append(parkingSlot.getParkingSlotType().name());
        builder.append("\n");
        builder.append("Vehicle Number: ").append(vehicle.getVehicleId());
        builder.append("\n");
        builder.append("Vehicle Type: ").append(vehicle.getVehicleType().name());
        builder.append("\n");
        builder.append("Parking Rate (per minutes): ").append(parkingSlot.getPrice());
        builder.append("\n");
        builder.append("Parking Floor: ").append(parkingSlot.getFloor());
        builder.append("\n");
        builder.append("Parking Row: ").append(parkingSlot.getRowNum());
        builder.append("\n");
        builder.append("Parking Column: ").append(parkingSlot.getColNum());
        builder.append("\n");
        log.info("Ticket Details \n {}", builder);
        log.info("Available parking slots: {}", ParkingUtility.getAvailableParkingSlot(parkingSlots));
    }
}
