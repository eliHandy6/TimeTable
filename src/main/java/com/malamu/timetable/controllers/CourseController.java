package com.malamu.timetable.controllers;

import com.malamu.timetable.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/courses")
@AllArgsConstructor
public class CourseController {

    private  final CourseService courseService;

    @GetMapping
    public String courses(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("courses",courseService.findAvailableCourses());
        return "course";
    }

}
