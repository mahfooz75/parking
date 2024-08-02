package com.selftechlearner;

import com.selftechlearner.model.ParkingSlotDetails;
import com.selftechlearner.model.Vehicle;
import com.selftechlearner.parkingenum.ParkingSlotTypeEnum;
import com.selftechlearner.parkingenum.VehicleTypeEnum;
import com.selftechlearner.slot.ParkingSlot;
import com.selftechlearner.slotmanager.ParkingSlotManager;
import com.selftechlearner.slotmanager.ParkingSlotManagerFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Parking {
    public static void main(String[] args) {
        ParkingSlotDetails twoWheelerParkingSlotDetails = ParkingSlotDetails.builder()
                .floors(List.of(1))
                .rows(List.of(1))
                .cols(List.of(1,2,3))
                .type(ParkingSlotTypeEnum.TWO_WHEELER_PARKING_SLOT)
                .build();
        List<ParkingSlot> twoWheelerParkingSlots = new ParkingSpace(twoWheelerParkingSlotDetails).getParkingSlots();
        List<ParkingSlot> parkingSlots = new ParkingSpace().getParkingSlots();
        log.info("Parking slot size {}", parkingSlots.size());
        ParkingSlotManagerFactory parkingSlotManagerFactory = new ParkingSlotManagerFactory();

        Vehicle vehicle = new Vehicle("123", VehicleTypeEnum.TWO_WHEELER);
        ParkingSlotManager parkingSlotManager = parkingSlotManagerFactory.getParkingSlotManager(vehicle.getVehicleType(), twoWheelerParkingSlots);
        parkingSlotManager.parkVehicle(vehicle);

        Vehicle vehicle1 = new Vehicle("345", VehicleTypeEnum.TWO_WHEELER);
        parkingSlotManager = parkingSlotManagerFactory.getParkingSlotManager(vehicle1.getVehicleType(), twoWheelerParkingSlots);
        parkingSlotManager.parkVehicle(vehicle1);

        Vehicle vehicle2 = Vehicle.builder()
                .vehicleId("345")
                .vehicleType(VehicleTypeEnum.TWO_WHEELER)
                .build();
        parkingSlotManager.removeVehicle(vehicle2);
        parkingSlotManager.removeVehicle(vehicle1);

        log.info("Parking slot size {}", twoWheelerParkingSlots.size());
    }
}
