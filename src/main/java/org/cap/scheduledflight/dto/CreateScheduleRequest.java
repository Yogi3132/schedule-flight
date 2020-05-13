package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class CreateScheduleRequest {

    private int availableseats;
    private BigInteger flightnumber;
    private BigInteger scheduleid;
    private String arrivaldatetime;
    private String departuredatetime;
    private BigInteger airportCode;
    private String sourceAiportName;
    private String destinationAirportName;

    public String getDeparturedatetime() {
        return departuredatetime;
    }

    public void setDeparturedatetime(String departuredatetime) {
        this.departuredatetime = departuredatetime;
    }


    public String getSourceAiportName() {
        return sourceAiportName;
    }

    public void setSourceAiportName(String sourceAiportName) {
        this.sourceAiportName = sourceAiportName;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public void setDestinationAirportName(String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
    }


    public BigInteger getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(BigInteger scheduleid) {
        this.scheduleid = scheduleid;
    }


    public BigInteger getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(BigInteger airportCode) {
        this.airportCode = airportCode;
    }


    public String getArrivaldatetime() {
        return arrivaldatetime;
    }

    public void setArrivaldatetime(String arrivaldatetime) {
        this.arrivaldatetime = arrivaldatetime;
    }


    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }


    public BigInteger getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(BigInteger flightnumber) {
        this.flightnumber = flightnumber;
    }


}

