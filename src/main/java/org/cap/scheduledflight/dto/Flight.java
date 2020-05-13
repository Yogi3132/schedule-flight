package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class Flight {
    public BigInteger getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(BigInteger flightnumber) {
        this.flightnumber = flightnumber;
    }

    private BigInteger flightnumber;


}
