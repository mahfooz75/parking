package com.selftechlearner.util;

import com.selftechlearner.slot.ParkingSlot;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ParkingUtility {
    public static int getAvailableParkingSlot(List<ParkingSlot> parkingSlotList) {
        return parkingSlotList.stream().filter(s -> s.isEmpty() && s.getVehicle() == null).toList().size();
    }
}
