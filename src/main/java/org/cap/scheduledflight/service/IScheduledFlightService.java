package org.cap.scheduledflight.service;


import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface IScheduledFlightService {
    ScheduledFlight addscheduledFlight(ScheduledFlight scheduledFlight); //schedules a flight

    List<ScheduledFlight> viewScheduledFlights(String sourceArg, String destinationArg, LocalDate time); //view list on the basis of source airport,destination airport and localdate

    ScheduledFlight viewScheduledFlights(BigInteger flightNumber); // view scheduled flight on the basis of flight number

    List<ScheduledFlight> viewScheduledFlight(); //list all the scheduled flight

    ScheduledFlight modifyScheduledFlight(BigInteger flightNumber, Schedule schedule, int availableseats);  //modify schedule on the basis of flight

    Boolean deleteScheduledFlight(BigInteger flightNumber); //delete scheduledfight on the basis of flightnumber


}
