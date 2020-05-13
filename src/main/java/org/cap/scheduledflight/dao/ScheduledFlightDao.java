package org.cap.scheduledflight.dao;


import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, Integer> {


    List<ScheduledFlight> findByFlightnumber(BigInteger flightnumber);
     @Query("from ScheduledFlight sf join sf.schedule sched where sched.sourceAirportName=:src" +
             " and sched.destinationAirportName=:dest and sched.departureDateTime=:departDate")
     List<ScheduledFlight> findBySourceAndDestination(@Param("src") String src,
                                               @Param("dest") String destination,
                                               @Param("departDate")LocalDate date);



}
