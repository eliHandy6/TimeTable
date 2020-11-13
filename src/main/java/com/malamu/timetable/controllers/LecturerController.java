package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.services.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/lecturers")
@AllArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;

    @GetMapping
    public String lecturers(Model model, RedirectAttributes redirectAttributes){
        Lecturer lecturer=new Lecturer();
        model.addAttribute("lecturer",lecturer);
        model.addAttribute("lecturers",lecturerService.findLecturers());
        return "lecturers";
    }

    @PostMapping("/save")
    public String newLecturer(@ModelAttribute("save") Lecturer lecturer, Model model, RedirectAttributes redirectAttributes){
        String name,message;
        lecturerService.createLecturer(lecturer);
        message = " Lecturer " + lecturer.getName() + " is successfully Saved";
        redirectAttributes.addFlashAttribute("data", message);
        redirectAttributes.addFlashAttribute("message", "success");
        return "redirect:/admin/lecturers";
    }
}
