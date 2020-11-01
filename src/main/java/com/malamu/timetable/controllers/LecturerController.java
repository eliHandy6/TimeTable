package com.malamu.timetable.controllers;

import com.malamu.timetable.services.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/lecturers")
@AllArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;

    @GetMapping
    public String lecturers(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("lecturers",lecturerService.findLecturers());
        return "lecturers";
    }
}
