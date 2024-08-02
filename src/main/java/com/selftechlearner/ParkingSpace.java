package com.selftechlearner;

import com.selftechlearner.model.ParkingSlotDetails;
import com.selftechlearner.parkingenum.ParkingSlotTypeEnum;
import com.selftechlearner.parkingenum.VehicleTypeEnum;
import com.selftechlearner.slot.ParkingSlot;
import com.selftechlearner.slot.ParkingSlotFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingSpace {
    private final List<ParkingSlot> parkingSlots;

    public ParkingSpace() {
        parkingSlots = new ArrayList<>();
        for (int floor = 1; floor <= 2; floor++) {
            for (int row = 1; row <= 2; row++) {
                for (int col = 1; col <= 5; col++) {
                    ParkingSlotTypeEnum slotTypeEnum = ParkingSlotTypeEnum.FOUR_WHEELER_PARKING_SLOT;
                    if (floor == 1) {
                        slotTypeEnum = ParkingSlotTypeEnum.TWO_WHEELER_PARKING_SLOT;
                    }
                    String parkingId = floor + String.valueOf(row) + col;
                    parkingSlots.add(ParkingSlot.builder()
                            .parkingId(parkingId)
                            .empty(true)
                            .parkingSlotType(slotTypeEnum)
                            .floor(floor)
                            .rowNum(row)
                            .colNum(col)
                            .build());
                }
            }
        }
    }

    public ParkingSpace(ParkingSlotDetails parkingSlotDetails) {
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.TWO_WHEELER;
        if(ParkingSlotTypeEnum.FOUR_WHEELER_PARKING_SLOT.name().equalsIgnoreCase(parkingSlotDetails.getType().name())){
            vehicleTypeEnum=VehicleTypeEnum.FOUR_WHEELER;
        }
        ParkingSlotFactory factory = new ParkingSlotFactory();
        ParkingSlot parkingSlot = factory.createParkingSlot(vehicleTypeEnum);
        parkingSlots = new ArrayList<>();
        for (int floor : parkingSlotDetails.getFloors()) {
            for (int row : parkingSlotDetails.getRows()) {
                for (int col : parkingSlotDetails.getCols()) {
                    String parkingId = floor + String.valueOf(row) + col;
                    parkingSlots.add(ParkingSlot.builder()
                            .parkingId(parkingId)
                            .empty(true)
                            .parkingSlotType(parkingSlotDetails.getType())
                            .floor(floor)
                            .rowNum(row)
                            .colNum(col)
                            .price(parkingSlot.getPrice())
                            .build());
                }
            }
        }
    }


    public List<ParkingSlot> getParkingSlots() {
        return Collections.unmodifiableList(parkingSlots);
    }
}
