package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class ScheduledFlightRequestDto {

    public BigInteger getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(BigInteger flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    private BigInteger flightNumber;
    private String airportName;
}
