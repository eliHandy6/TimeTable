package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Course;
import com.malamu.timetable.models.Payload;
import com.malamu.timetable.repositories.UnitsRepository;
import com.malamu.timetable.services.CourseService;
import com.malamu.timetable.services.DeptServices;
import com.malamu.timetable.services.LecturerService;
import com.malamu.timetable.services.UnitsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    private  final CourseService courseService;
    private final DeptServices deptServices;
    private final UnitsService unitsService;
    private final LecturerService lecturerService;
    private final UnitsRepository unitsRepository;


    public CourseController(CourseService courseService, DeptServices deptServices, UnitsService unitsService, LecturerService lecturerService, UnitsRepository unitsRepository) {
        this.courseService = courseService;
        this.deptServices = deptServices;
        this.unitsService = unitsService;
        this.lecturerService = lecturerService;
        this.unitsRepository = unitsRepository;
    }

    @GetMapping
    public String courses(Model model, RedirectAttributes redirectAttributes){

        Course course=new Course();
        model.addAttribute("course",course);
        model.addAttribute("depts",deptServices.findAllDepts());
        model.addAttribute("units",unitsRepository.findAll());
        model.addAttribute("lecturers",lecturerService.findLecturers());
        model.addAttribute("courses",courseService.findAvailableCourses());
        return "course";
    }

    @PostMapping("/units/{id}")
    public String findbyDept(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        System.out.println(id);
        return "redirect:/admin/courses";
    }

}
