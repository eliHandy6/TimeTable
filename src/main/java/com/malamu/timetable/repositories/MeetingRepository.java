package com.malamu.timetable.repositories;

import com.malamu.timetable.models.MeetingTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingTimes,Integer> {


}
