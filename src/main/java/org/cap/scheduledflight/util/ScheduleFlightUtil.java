package org.cap.scheduledflight.util;

import org.cap.scheduledflight.controller.ScheduledFlightController;
import org.cap.scheduledflight.dto.CreateScheduleRequest;
import org.cap.scheduledflight.dto.Flight;
import org.cap.scheduledflight.dto.ScheduledFlightDetailsDto;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleFlightUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private static final Logger Log = LoggerFactory.getLogger(ScheduleFlightUtil.class);


    public static List<ScheduledFlightDetailsDto>scheduleFlightDetails(List<ScheduledFlight>scheduledFlights){
        List<ScheduledFlightDetailsDto>desired=new ArrayList<>();
        for (ScheduledFlight scheduledFlight:scheduledFlights){
           ScheduledFlightDetailsDto details= scheduleFlightDetails(scheduledFlight);
           desired.add(details);
        }
        return desired;
    }

    public static ScheduledFlightDetailsDto scheduleFlightDetails(ScheduledFlight scheduledFlight) {

        ScheduledFlightDetailsDto scheduledFlightDetailsDto = new ScheduledFlightDetailsDto();
        scheduledFlightDetailsDto.setAvailableseats(scheduledFlight.getAvailableseats());

        scheduledFlightDetailsDto.setFlightnumber(scheduledFlight.getFlightnumber());

        Schedule schedule=scheduledFlight.getSchedule();
        //Airport
        // Aiport airport = fetchAirportbyAirportCode(airportCode);
        scheduledFlightDetailsDto.setSourceairport(schedule.getSourceAirportName());
        scheduledFlightDetailsDto.setDestinationairport(schedule.getDestinationAirportName());

        LocalDateTime arrivalDateTime=schedule.getArrivalDateTime();
        Log.info("inside convertToResponseDto, arrivaldatetime="+arrivalDateTime);
        String arrivalDateText=arrivalDateTime.format(formatter);
        scheduledFlightDetailsDto.setArrivaldatetime(arrivalDateText);
        LocalDateTime departureDate=schedule.getDeparturedatetime();
        String departureDateText=departureDate.format(formatter);
        scheduledFlightDetailsDto.setDeparturedatetime(departureDateText);

        Log.info("inside convertToResponseDto, departuredatetime="+departureDate);
        return scheduledFlightDetailsDto;
    }


    public static ScheduledFlightDetailsDto scheduleFlightDetailsmodfiy(BigInteger flightNumber,Schedule schedule,
                                                                        int availableseats) {

        ScheduledFlightDetailsDto scheduledFlightDetailsDto = new ScheduledFlightDetailsDto();
        ScheduledFlight scheduledFlight =new ScheduledFlight();
        scheduledFlightDetailsDto.setAvailableseats(scheduledFlight.getAvailableseats());

        scheduledFlightDetailsDto.setFlightnumber(scheduledFlight.getFlightnumber());



        //Airport
        // Aiport airport = fetchAirportbyAirportCode(airportCode);
        scheduledFlightDetailsDto.setSourceairport(schedule.getSourceAirportName());
        scheduledFlightDetailsDto.setDestinationairport(schedule.getDestinationAirportName());

        LocalDateTime arrivalDateTime=schedule.getArrivalDateTime();
        Log.info("inside convertToResponseDto, arrivaldatetime="+arrivalDateTime);
        String arrivalDateText=arrivalDateTime.format(formatter);
        scheduledFlightDetailsDto.setArrivaldatetime(arrivalDateText);
        LocalDateTime departureDate=schedule.getDeparturedatetime();
        String departureDateText=departureDate.format(formatter);
        scheduledFlightDetailsDto.setDeparturedatetime(departureDateText);

        Log.info("inside convertToResponseDto, departuredatetime="+departureDate);
        return scheduledFlightDetailsDto;
    }






}
