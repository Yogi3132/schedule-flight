package org.cap.scheduledflight.controller;

import org.cap.scheduledflight.dto.Aiport;
import org.cap.scheduledflight.dto.CreateScheduleRequest;
import org.cap.scheduledflight.dto.Flight;
import org.cap.scheduledflight.dto.ScheduledFlightDetailsDto;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.cap.scheduledflight.exceptions.ScheduledFlightNotFoundException;
import org.cap.scheduledflight.service.IScheduledFlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/scheduledflights")
public class ScheduledFlightController {
    @Autowired
    private IScheduledFlightService scheduledFlightService;

    private static final Logger Log = LoggerFactory.getLogger(ScheduledFlightController.class);


    @PostMapping("/add")
    public ResponseEntity<ScheduledFlightDetailsDto> createScheduledFlightRequest(@RequestBody CreateScheduleRequest requestdata) {

        ScheduledFlight scheduledFlight = new ScheduledFlight();
        scheduledFlight.setFlightnumber(requestdata.getFlightnumber());
        scheduledFlight.setAvailableseats(requestdata.getAvailableseats());
        Schedule schedule = new Schedule();
        schedule.setSourceAirportName(requestdata.getSourceAiportName());
        schedule.setDestinationAirportName(requestdata.getDestinationAirportName());
        scheduledFlight.setSchedule(schedule);


        String arrivalTimeString = requestdata.getArrivaldatetime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalTimeString, formatter);
        schedule.setDeparturedatetime(arrivalDateTime);

        String departureTimeString = requestdata.getArrivaldatetime();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        LocalDateTime departureDateTime = LocalDateTime.parse(departureTimeString, formatters);
        schedule.setDeparturedatetime(departureDateTime);

        scheduledFlightService.addscheduledFlight(scheduledFlight);
        ScheduledFlightDetailsDto scheduledFlightDetailsDto = convertToResponseDto(scheduledFlight, requestdata.getAirportCode());
        ResponseEntity<ScheduledFlightDetailsDto> response = new ResponseEntity<>(scheduledFlightDetailsDto, HttpStatus.OK);
        return response;
    }


    private ScheduledFlightDetailsDto convertToResponseDto(ScheduledFlight scheduledFlight, BigInteger airportCode) {
        ScheduledFlightDetailsDto scheduledFlightDetailsDto = new ScheduledFlightDetailsDto();
        scheduledFlightDetailsDto.setAvailableseats(scheduledFlight.getAvailableseats());

        //Flight
        Flight flight = getFlightDetails(scheduledFlightDetailsDto.getFlightnumber());
        scheduledFlightDetailsDto.setFlightnumber(flight.getFlightnumber());
        //Airport
        Aiport airport = fetchairportbyairportCode(airportCode);
        scheduledFlightDetailsDto.setSourceairport(airport.getSourceairportName());
        scheduledFlightDetailsDto.setDestinationairport(airport.getDestinationairportName());

        //  Schedule
      //  Schedule schedule = new Schedule();
       // LocalDateTime arrivalDateTimelocal = schedule.getArrivalDateTime();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        //String arrivalDateTime= arrivalDateTimelocal.format(formatter);
        //scheduledFlightDetailsDto.setArrivaldatetime(arrivalDateTime);


       // LocalDateTime departureDateTimelocal = schedule.getArrivalDateTime();
        //DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        //String departuredateTime= arrivalDateTimelocal.format(formatters);
        //scheduledFlightDetailsDto.setArrivaldatetime(departuredateTime);

        return scheduledFlightDetailsDto;
    }


    private Aiport fetchairportbyairportCode(BigInteger airportCode) {
        Aiport airport = new Aiport();
        airport.setAirportCode(new BigInteger("100"));
        airport.setSourceairportName("RAJA BHOJ");
        airport.setDestinationairportName("INDIRA GANDHI AIRPORT");

        return airport;
    }

    private Flight getFlightDetails(BigInteger flightNumber) {


        Flight flight = new Flight();
        flight.setFlightnumber(new BigInteger("101"));
        return flight;
    }


    @GetMapping("/get/{flightnumber}")
    public ResponseEntity<ScheduledFlight> getScheduledflightsByflightnumber(@PathVariable("flightnumber") BigInteger flightnumber) {
        ScheduledFlight scheduledFlight = scheduledFlightService.viewScheduledFlights(flightnumber);
        ResponseEntity<ScheduledFlight> response = new ResponseEntity<>(scheduledFlight, HttpStatus.OK);
        return response;
    }


    @GetMapping("/fetch/srcdest/{src}/{dest}/{date}")
    public ResponseEntity<List<ScheduledFlight>> fetchFlightsbetweenSrcandDest(@PathVariable String src,
                                                                               @PathVariable String dest,
                                                                               String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate arrivalDate = LocalDate.parse(date, formatter);
        List<ScheduledFlight> scheduledFlights = scheduledFlightService.viewScheduledFlights(src, dest, arrivalDate);
        ResponseEntity<List<ScheduledFlight>> response = new ResponseEntity<>(scheduledFlights, HttpStatus.OK);
        return response;
    }


    @DeleteMapping("/delete/{flightnumber}")
    public ResponseEntity<Boolean> deleteBookingById(@PathVariable("flightnumber") BigInteger flightnumber) {
        ScheduledFlight scheduledFlight = scheduledFlightService.viewScheduledFlights(flightnumber);
        ResponseEntity<Boolean> response;
        if (scheduledFlight != null) {
            Boolean result = scheduledFlightService.deleteScheduledFlight(flightnumber);
            response = new ResponseEntity<>(result, HttpStatus.OK);

        } else
            response = new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        return response;
    }


    @GetMapping
    public ResponseEntity<List<ScheduledFlight>> fetchScheduledflights() {
        List<ScheduledFlight> scheduledFlights = scheduledFlightService.viewScheduledFlight();
        ResponseEntity<List<ScheduledFlight>> response = new ResponseEntity<>(scheduledFlights, HttpStatus.OK);
        return response;
    }

/*
       @PutMapping("/modify/{flightnumber}")
       ResponseEntity<ScheduledFlightDetailsDto> modify(@PathVariable("flightnumber") BigInteger flightnumber, @Valid @RequestBody CreateScheduleRequest dto) {
           ScheduledFlightDetailsDto scheduledFlightDetailsDto = convertToResponseDto(dto,flightnumber);
          ScheduledFlight scheduledFlight = scheduledFlightService.viewScheduledFlights(flightnumber);
           scheduledFlight.setAvailableseats(dto.getAvailableseats());
           Schedule schedule = new Schedule();
           schedule.setSourceairportName(dto.getSourceAiportName());
           schedule.setDestinationairportName(dto.getDestinationAirportName());



           String arrivalTimeString=dto.getArrivaldatetime();
           DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yy hh:mm");
           LocalDateTime arrivalDateTime=LocalDateTime.parse(arrivalTimeString,formatter);
           schedule.setArrivaldatetime(arrivalDateTime);

           String departureTimeString=dto.getArrivaldatetime();
           DateTimeFormatter formatters =DateTimeFormatter.ofPattern("dd-MM-yy hh:mm");
           LocalDateTime departureDateTime=LocalDateTime.parse(departureTimeString,formatters);
           schedule.setDeparturedatetime(departureDateTime);

           scheduledFlightService.modifyScheduledFlight(flightnumber,schedule,scheduledFlight.getAvailableseats());

           ResponseEntity<ScheduledFlightDetailsDto> response = new ResponseEntity<>(scheduledFlightDetailsDto, HttpStatus.OK);
           return response;

       }

*/


    @ExceptionHandler(ScheduledFlightNotFoundException.class)
    public ResponseEntity<String> handleScheduleflightnotfound(ScheduledFlightNotFoundException ex) {
        Log.error("Schedule Flight Not Found ", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        return response;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolate(ConstraintViolationException ex) {
        Log.error("constraint violation", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleAll(Throwable ex) {
        Log.error("Something went wrong", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }


}

