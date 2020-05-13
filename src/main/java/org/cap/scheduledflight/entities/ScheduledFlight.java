package org.cap.scheduledflight.entities;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "scheduledflight")
public class ScheduledFlight {


    @Id
    @GeneratedValue
    private int schedule_flight_id;

    private BigInteger flightnumber;
    private int availableseats;

    @OneToOne
    private Schedule schedule;


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


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getSchedule_flight_id() {
        return schedule_flight_id;
    }

    public void setSchedule_flight_id(int schedule_flight_id) {
        this.schedule_flight_id = schedule_flight_id;


    }
}

