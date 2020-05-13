package org.cap.empmgt.service;

import org.cap.scheduledflight.dao.ScheduledFlightDao;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.cap.scheduledflight.service.IScheduledFlightService;
import org.cap.scheduledflight.service.ScheduledFlightServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.List;



    @DataJpaTest// for jpa tests
    @ExtendWith(SpringExtension.class)// integrate spring test framework with junit5
    @Import(ScheduledFlightServiceImpl.class)
// importing RoomServiceImpl class as @DatajpaTest will only only search for repositories
    public class ScheduledFlightServiceImplTest {

        @Autowired
        private IScheduledFlightService scheduledFlightService;

        @Autowired
        private ScheduledFlightDao scheduledFlightDao;

        /**
         * case when room does not exist in database before
         */

        @Test
        public void testSaveScheduledFlight_1(){
            BigInteger flightnumber=new BigInteger("23");
            int availableseats=100;
            String sourceairportName="RAJA BHOJ";
            String destinationairportName="Indira Gandhi";
            ScheduledFlight scheduledFlight=new ScheduledFlight();
            scheduledFlight.setFlightnumber(flightnumber);
            scheduledFlight.setAvailableseats(availableseats);
            Schedule schedule = new Schedule();
            schedule.setSourceAirportName(sourceairportName);
            schedule.setDestinationAirportName(destinationairportName);
            ScheduledFlight result=scheduledFlightService.addscheduledFlight(scheduledFlight);
            System.out.println("result="+result.getSchedule_flight_id());
            List<ScheduledFlight> fetched= scheduledFlightDao.findAll();
            Assertions.assertEquals(1,fetched.size());// verifying one got inserted
            ScheduledFlight expected=fetched.get(0);
            Assertions.assertEquals(expected,result);// verifying fetch and stored are equal
            Assertions.assertEquals(flightnumber,expected.getFlightnumber());
            Assertions.assertEquals(availableseats,expected.getAvailableseats());
            Assertions.assertEquals(schedule,expected.getSchedule());

        }


/*
        @Test
        public void testFindByFlightNumber_1(){
            BigInteger flightnumber=new BigInteger("23");
            int availableseats=100;
            ScheduledFlight scheduledFlight=new ScheduledFlight();
           scheduledFlight.setAvailableseats(availableseats);
           scheduledFlight.setFlightnumber(flightnumber);

           scheduledFlight = scheduledFlightDao.save(scheduledFlight);

           BigInteger flightno = scheduledFlight.getFlightnumber();
           ScheduledFlight result = scheduledFlightService.viewScheduledFlights(flightno);

           Assertions.assertEquals(scheduledFlight,result);
           Assertions.assertEquals(availableseats,scheduledFlight.getAvailableseats());
           Assertions.assertEquals(flightnumber,scheduledFlight.getFlightnumber());

        }

 */




}
