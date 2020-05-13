package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class ScheduledFlightDetailsDto {
    private BigInteger flightnumber;
    private int availableseats;
    private String sourceairport;
    private String destinationairport;
    private String arrivaldatetime;
    private String departuredatetime;

    public BigInteger getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(BigInteger flightnumber) {
        this.flightnumber = flightnumber;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public String getSourceairport() {
        return sourceairport;
    }

    public void setSourceairport(String sourceairport) {
        this.sourceairport = sourceairport;
    }

    public String getDestinationairport() {
        return destinationairport;
    }

    public void setDestinationairport(String destinationairport) {
        this.destinationairport = destinationairport;
    }

    public String getArrivaldatetime() {
        return arrivaldatetime;
    }

    public void setArrivaldatetime(String arrivaldatetime) {
        this.arrivaldatetime = arrivaldatetime;
    }

    public String getDeparturedatetime() {
        return departuredatetime;
    }

    public void setDeparturedatetime(String departuredatetime) {
        this.departuredatetime = departuredatetime;
    }


}