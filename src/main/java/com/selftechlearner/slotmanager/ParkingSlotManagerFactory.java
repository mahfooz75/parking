package com.selftechlearner.slotmanager;

import com.selftechlearner.exception.ParkingSlotNotSupported;
import com.selftechlearner.parkingenum.VehicleTypeEnum;
import com.selftechlearner.slot.ParkingSlot;

import java.util.List;

public class ParkingSlotManagerFactory {

    public ParkingSlotManager getParkingSlotManager(VehicleTypeEnum vehicleType, List<ParkingSlot> parkingSlots) {
        if (vehicleType == VehicleTypeEnum.FOUR_WHEELER) {
            return new FourWheelerParkingSlotManager(parkingSlots);
        } else if (vehicleType == VehicleTypeEnum.TWO_WHEELER) {
            return new TwoWheelerParkingSlotManager(parkingSlots);
        } else {
            throw new ParkingSlotNotSupported("Parking slot type not supported");
        }
    }
}
