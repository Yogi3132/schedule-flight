package org.cap.scheduledflight.entities;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private int scheduleid;

    private String sourceAirportName;
    private String destinationAirportName;
    private LocalDateTime arrivalDateTime;
    private LocalDateTime departureDateTime;


    public LocalDateTime getDeparturedatetime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setDeparturedatetime(LocalDateTime departuredatetime) {
        this.departureDateTime = departuredatetime;
    }


    public String getSourceAirportName() {
        return sourceAirportName;
    }

    public void setSourceAirportName(String sourceAirportName) {
        this.sourceAirportName = sourceAirportName;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public void setDestinationAirportName(String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
    }

    public int getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(int scheduleid) {
        this.scheduleid = scheduleid;
    }


}
