/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malamu.timetable.models.timetablealgorithm;

import com.malamu.timetable.models.*;
import com.malamu.timetable.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;



/**
 *
 * @author Jexi
 */

@lombok.Data
@Service
public class Data {

    @Autowired
    MeetingService meetingService;

    @Autowired
     RoomService roomService;
    @Autowired
    LecturerService lecturerService;
    @Autowired
    CourseService courseService;
    @Autowired
    DeptServices deptService;

    private ArrayList<Room> rooms;
    private ArrayList<Lecturer> instructor;
    private ArrayList<Course> courses;
    private ArrayList<Depts> depts;
    private ArrayList<MeetingTimes> meetingTimes;
    private int numberofClasses =0;
    public Data initialize(int deptId){
        System.out.println(deptId+"Hellooooooooooooooo");
         rooms= (ArrayList<Room>) roomService.findAvailableRooms();
         meetingTimes= (ArrayList<MeetingTimes>) meetingService.findAll();
         instructor= (ArrayList<Lecturer>) lecturerService.findLecturers();
         courses= (ArrayList<Course>) courseService.findAvailableCourses();
         depts= (ArrayList<Depts>) deptService.findAllDepts();
         depts.forEach(x -> numberofClasses += x.getCourses().size());

       return this; 
    }


}
