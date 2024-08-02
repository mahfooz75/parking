package com.selftechlearner.model;

import com.selftechlearner.slot.ParkingSlot;
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
public class Ticket {
    private String ticketId;
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
}
