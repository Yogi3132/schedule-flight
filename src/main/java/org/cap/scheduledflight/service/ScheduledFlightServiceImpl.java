package org.cap.scheduledflight.service;


import org.cap.scheduledflight.dao.ScheduleDao;
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
import java.util.List;

@Service
@Transactional
public class ScheduledFlightServiceImpl implements IScheduledFlightService {

    @Autowired
    private ScheduledFlightDao scheduledflightdao;

    @Autowired
    private ScheduleDao scheduledao;


    @Override
    public ScheduledFlight addscheduledFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlight == null) {
            throw new InvalidArgumentException("Scheduleflight cannot be null ");
        }
        Schedule schedule = scheduledFlight.getSchedule();
        scheduledao.save(schedule);
        scheduledFlight = scheduledflightdao.save(scheduledFlight);
        return scheduledFlight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(String sourceArg, String destinationArg, LocalDate time) {
        List<ScheduledFlight> list = scheduledflightdao.findBySourceAndDestination(sourceArg, destinationArg, time);
        return list;

    }


    public ScheduledFlight findbyflightnumber(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new InvalidArgumentException("Flight number can't be null");
        }
        List<ScheduledFlight> scheduledFlights = scheduledflightdao.findByFlightnumber(flightNumber);
        if (scheduledFlights.isEmpty()) {
            throw new ScheduledFlightNotFoundException("Schedule Not found for flight number +" + flightNumber);
        }
        ScheduledFlight flight = scheduledFlights.get(0);
        return flight;

    }

    @Override
    public ScheduledFlight viewScheduledFlights(BigInteger flightNumber) {
        ScheduledFlight scheduledFlight = findbyflightnumber(flightNumber);
        return scheduledFlight;

    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> scheduledFlight = scheduledflightdao.findAll();
        return scheduledFlight;
    }



    @Override
    public ScheduledFlight modifyScheduledFlight(BigInteger flightNumber, Schedule schedule, int availableseats) {
        ScheduledFlight scheduledFlight = findbyflightnumber(flightNumber);
        scheduledFlight.setSchedule(schedule);
        scheduledFlight.setAvailableseats(availableseats);
        scheduledFlight = scheduledflightdao.save(scheduledFlight);
        scheduledao.save(schedule);
        return scheduledFlight;
    }


    @Override
    public Boolean deleteScheduledFlight(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new InvalidArgumentException("Flight Number Cannot be null");
        }
        ScheduledFlight flight = findbyflightnumber(flightNumber);
        scheduledflightdao.delete(flight);
        return true;
    }


}



