package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Depts;
import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.models.MeetingTimes;
import com.malamu.timetable.services.CourseService;
import com.malamu.timetable.services.DeptServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/depts")
@AllArgsConstructor
public class DeptsController {

    private  final DeptServices deptServices;

    @GetMapping
    public String depts(Model model, RedirectAttributes redirectAttributes){
        Depts  depts=new Depts();
        model.addAttribute("department",depts);
        model.addAttribute("depts",deptServices.findAllDepts());
        return "departments";
    }



}
