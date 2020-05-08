package org.cap.scheduledflight.service;


import org.cap.scheduledflight.dao.ScheduledFlightDao;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.cap.scheduledflight.exceptions.InvalidArgumentException;
import org.cap.scheduledflight.exceptions.ScheduledFlightNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class ScheduledFlightServiceImpl implements IScheduledFlightService {

    @Autowired
    private ScheduledFlightDao dao;


    @Override
    public ScheduledFlight addscheduledFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlight == null) {
            throw new InvalidArgumentException("ScheduledFlight information cannot be Null");
        }
        scheduledFlight = dao.save(scheduledFlight);
        return scheduledFlight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(String sourceArg, String destinationArg, LocalDate time) {
            Schedule sf = new Schedule();
            sf.setAirportName(sourceArg);
            sf.setAirportName(destinationArg);
            sf.setArrivalTime(time);
            List<ScheduledFlight> scheduledFlight= dao.findAll();
            return scheduledFlight;
        }



    @Override
    public ScheduledFlight viewScheduledFlights(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new InvalidArgumentException("Flight number can't be null");
        }
        Optional<ScheduledFlight> optionalScheduledFlight = dao.findById(flightNumber);
        if (optionalScheduledFlight.isPresent()) {
            return optionalScheduledFlight.get();
        }
        throw new ScheduledFlightNotFoundException("Schedule Not found for flight number +" + flightNumber);

    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> scheduledFlight= dao.findAll();
        return scheduledFlight;
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(BigInteger flightNumber, Schedule schedule, int availableseats) {
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        dao.findById(flightNumber);
        scheduledFlight.setSchedule(schedule);
        scheduledFlight.setAvailableseats(availableseats);
        scheduledFlight = dao.save(scheduledFlight);
        return scheduledFlight;
    }

    @Override
    public Boolean deleteScheduledFlight(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new InvalidArgumentException("Flight Number Cannot be null");
        }
        Optional<ScheduledFlight> optionalScheduledFlight = dao.findById(flightNumber);
        if (optionalScheduledFlight.isPresent()) {
            dao.deleteById(flightNumber);
            return true;
        }
        throw new ScheduledFlightNotFoundException("Schedule Not found for Booking Id +" + flightNumber);

    }

}



