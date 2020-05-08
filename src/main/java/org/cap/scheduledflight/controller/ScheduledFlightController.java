package org.cap.scheduledflight.controller;

import org.cap.scheduledflight.dto.ScheduledFlightDetailsDto;
import org.cap.scheduledflight.dto.ScheduledFlightRequestDto;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.cap.scheduledflight.service.IScheduledFlightService;
import org.cap.scheduledflight.service.ScheduledFlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/scheduledflights")
public class ScheduledFlightController {
    @Autowired
    private IScheduledFlightService ScheduledFlightService;








    @GetMapping
    public ResponseEntity<List<ScheduledFlight>> fetchAllScheduledFlight() {
        List<ScheduledFlight> bookings = ScheduledFlightService.viewScheduledFlight();
        ResponseEntity<List<ScheduledFlight>> response = new ResponseEntity<>(bookings, HttpStatus.OK);
        return response;
    }

    @GetMapping("/get/{flightnumber}")
    public ResponseEntity<ScheduledFlight> getScheduledFlightByFlightNumber(@PathVariable("flightnumber") BigInteger flightnumber) {
        ScheduledFlight scheduledFlight = ScheduledFlightService.viewScheduledFlights(flightnumber);
        ResponseEntity<ScheduledFlight> response = new ResponseEntity<>(scheduledFlight, HttpStatus.OK);
        return response;
    }



    @DeleteMapping("/delete/{flightnumber}")
    public ResponseEntity<Boolean> deleteScheduledFlightByFlightNumber(@PathVariable("flightnumber") BigInteger flightnumber) {
        Boolean result = ScheduledFlightService.deleteScheduledFlight(flightnumber);
        ResponseEntity<Boolean> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }


}