package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class Aiport {


    public String getSourceairportName() {
        return sourceairportName;
    }

    public void setSourceairportName(String sourceairportName) {
        this.sourceairportName = sourceairportName;
    }

    private String sourceairportName;

    public String getDestinationairportName() {
        return destinationairportName;
    }

    public void setDestinationairportName(String destinationairportName) {
        this.destinationairportName = destinationairportName;
    }

    private String destinationairportName;


    public BigInteger getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(BigInteger airportCode) {
        this.airportCode = airportCode;
    }

    private BigInteger airportCode;
}
