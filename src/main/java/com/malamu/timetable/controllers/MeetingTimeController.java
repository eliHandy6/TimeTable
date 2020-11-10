package com.malamu.timetable.controllers;

import com.malamu.timetable.services.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/periods")
@AllArgsConstructor
public class MeetingTimeController {

    private  final MeetingService meetingService;

    @GetMapping
    public String depts(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("periods",meetingService.findAll());
        return "periods";
    }
}
