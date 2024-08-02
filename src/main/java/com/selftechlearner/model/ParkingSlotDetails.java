package com.selftechlearner.model;

import com.selftechlearner.parkingenum.ParkingSlotTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSlotDetails {
    private List<Integer> floors;
    private List<Integer> rows;
    private List<Integer> cols;
    private ParkingSlotTypeEnum type;
}
