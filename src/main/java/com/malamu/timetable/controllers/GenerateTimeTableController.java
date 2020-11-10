package com.malamu.timetable.controllers;

import com.malamu.timetable.models.*;
import com.malamu.timetable.services.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/generatetimetable")
@AllArgsConstructor
@Data
public class GenerateTimeTableController {

    private  final RoomService roomService;
    private  final LecturerService lecturerService;
    private  final CourseService courseService;
    private  final DeptServices deptService;
    private  final MeetingService meetingService;

   List<Room> roomList=roomService.findAvailableRooms();
   List<Lecturer> lecturerList=lecturerService.findLecturers();
   List<Course> courseList=courseService.findAvailableCourses();
   List<Depts> deptsList=deptService.findAllDepts();
   List<MeetingTimes> timesList=meetingService.findAll();



}
