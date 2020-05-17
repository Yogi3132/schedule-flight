package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class CreateScheduleRequest {

    private int availableseats;
    private BigInteger flightnumber;
    private BigInteger scheduleid;
    private String arrivaldatetime;
    private String departuredatetime;
    private BigInteger airportCode;
    private String sourceairportname;
    private String destinationairportname;


    public String getSourceairportname() {
        return sourceairportname;
    }

    public void setSourceairportname(String sourceairportname) {
        this.sourceairportname = sourceairportname;
    }


    public String getDeparturedatetime() {
        return departuredatetime;
    }

    public void setDeparturedatetime(String departuredatetime) {
        this.departuredatetime = departuredatetime;
    }




    public String getDestinationairportname() {
        return destinationairportname;
    }

    public void setDestinationairportname(String destinationairportname) {
        this.destinationairportname = destinationairportname;
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

