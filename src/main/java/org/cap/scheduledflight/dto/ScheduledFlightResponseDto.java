package org.cap.scheduledflight.dto;

public class ScheduledFlightResponseDto {

    private int ScheduleId;

    private String airportName;

    public int getScheduleId() {
        return ScheduleId;
    }

    public void setScheduleId(int scheduleId) {
        ScheduleId = scheduleId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
