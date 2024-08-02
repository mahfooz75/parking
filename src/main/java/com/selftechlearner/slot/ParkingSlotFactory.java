package com.selftechlearner.slot;

import com.selftechlearner.parkingenum.VehicleTypeEnum;

public class ParkingSlotFactory {
    public ParkingSlot createParkingSlot(VehicleTypeEnum vehicleType) {
        ParkingSlot parkingSlot = null;
        if (VehicleTypeEnum.FOUR_WHEELER.name().equalsIgnoreCase(vehicleType.name())) {
            parkingSlot = new FourWheelerParkingSlot();
        } else if (VehicleTypeEnum.TWO_WHEELER.name().equalsIgnoreCase(vehicleType.name())) {
            parkingSlot = new TwoWheelerParkingSlot();
        }
        return parkingSlot;
    }
}
