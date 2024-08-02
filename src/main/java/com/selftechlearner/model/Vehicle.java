package com.selftechlearner.model;

import com.selftechlearner.parkingenum.VehicleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Vehicle {
    private String vehicleId;
    private VehicleTypeEnum vehicleType;
}
