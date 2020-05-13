package org.cap.scheduledflight.dao;

import org.cap.scheduledflight.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Integer> {
}
