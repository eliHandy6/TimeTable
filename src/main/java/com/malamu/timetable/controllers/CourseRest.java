package com.malamu.timetable.controllers;

import com.malamu.timetable.models.*;
import com.malamu.timetable.services.CourseService;
import com.malamu.timetable.services.DeptServices;
import com.malamu.timetable.services.LecturerService;
import com.malamu.timetable.services.UnitsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/rest_courses")
public class CourseRest {

    private  final DeptServices deptServices;
    private  final LecturerService lecturerService;
    private  final UnitsService unitsService;
    private  final CourseService courseService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Payload payload){

        System.out.println(payload.toString());

        //Department

        Depts depts=deptServices.findDeptbyId((int) payload.getDepartment());

        payload.getCourse_details().forEach(detailsDTO -> {
            //lecturer
            Lecturer lecturer=lecturerService.findLecturerById((int) detailsDTO.getLecturer());
            //unit
            Units units =unitsService.findById((int) detailsDTO.getUnit_id());
            //number of students

            int no= (int) detailsDTO.getNo_of_students();
            //create object to save

            Course course=new Course(depts,lecturer,units,no);

            courseService.createCourse(course);

            depts.getCourses().add(course);


        });

        return new ResponseEntity<>("Success", HttpStatus.OK);

    }
}
