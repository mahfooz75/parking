package com.selftechlearner.slotmanager;

import com.selftechlearner.model.Vehicle;
import com.selftechlearner.slot.ParkingSlot;

import java.util.List;

public abstract class ParkingSlotManager {
    final List<ParkingSlot> parkingSlotList;

    ParkingSlotManager(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    abstract ParkingSlot findParkingSlot();

    public ParkingSlot parkVehicle(Vehicle v) {
        ParkingSlot slot = findParkingSlot();
        slot.setVehicle(v);
        slot.setEmpty(false);
        return slot;
    }

    public void removeVehicle(Vehicle v) {
        for (ParkingSlot slot : parkingSlotList) {
            if (!slot.isEmpty() && slot.getVehicle() != null && slot.getVehicle().equals(v)) {
                slot.setVehicle(null);
                slot.setEmpty(true);
                break;
            }
        }
    }
}
