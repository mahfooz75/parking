package com.selftechlearner.slot;

import com.selftechlearner.model.Vehicle;
import com.selftechlearner.parkingenum.ParkingSlotTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSlot {
    private String parkingId;
    private int rowNum;
    private int colNum;
    private int floor;
    private double price;
    private boolean empty = true;
    private Vehicle vehicle;
    private ParkingSlotTypeEnum parkingSlotType;
}
