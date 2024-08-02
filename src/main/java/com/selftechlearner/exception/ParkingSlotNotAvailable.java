package com.selftechlearner.exception;

public class ParkingSlotNotAvailable extends RuntimeException {

    public ParkingSlotNotAvailable(String msg) {
        super(msg);
    }
}
