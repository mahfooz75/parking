package com.selftechlearner.slotmanager;

import com.selftechlearner.exception.ParkingSlotNotAvailable;
import com.selftechlearner.parkingenum.ParkingSlotTypeEnum;
import com.selftechlearner.slot.ParkingSlot;

import java.util.List;
import java.util.Optional;

public class TwoWheelerParkingSlotManager extends ParkingSlotManager {
    TwoWheelerParkingSlotManager(List<ParkingSlot> parkingSlotList) {
        super(parkingSlotList);
    }

    @Override
    public ParkingSlot findParkingSlot() {
        Optional<ParkingSlot> optionalParkingSlot = parkingSlotList.stream()
                .filter(slot -> slot.getParkingSlotType() == ParkingSlotTypeEnum.TWO_WHEELER_PARKING_SLOT && slot.isEmpty() && slot.getVehicle() == null
                ).findFirst();
        return optionalParkingSlot.orElseThrow(() -> new ParkingSlotNotAvailable("Two wheeler parking slot not available"));
    }
}
