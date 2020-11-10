package com.malamu.timetable.services;

import com.malamu.timetable.models.MeetingTimes;
import com.malamu.timetable.repositories.MeetingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MeetingService {

    private  final MeetingRepository meetingRepository;

    //CRUD

    @Transactional
    public MeetingTimes createMeetingTime(MeetingTimes meetingTimes){
        return meetingRepository.save(meetingTimes);
    }
    @Transactional
    public List<MeetingTimes> findAll(){
        return meetingRepository.findAll();
    }

    @Transactional
    public  MeetingTimes updateTime(int id,MeetingTimes meetingTimes){
        MeetingTimes meetingTimes1=meetingRepository.findById(id).get();
        meetingTimes1.setStartTime(meetingTimes.getStartTime());
        meetingTimes1.setEndTime(meetingTimes.getEndTime());
        return createMeetingTime(meetingTimes1);
    }

}
