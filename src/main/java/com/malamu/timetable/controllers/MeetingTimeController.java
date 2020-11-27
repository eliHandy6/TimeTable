package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.models.MeetingTimes;
import com.malamu.timetable.models.Room;
import com.malamu.timetable.services.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/periods")
@AllArgsConstructor
public class MeetingTimeController {

    private  final MeetingService meetingService;

    @GetMapping
    public String depts(Model model, RedirectAttributes redirectAttributes){
        MeetingTimes meetingTimes=new MeetingTimes();
        model.addAttribute("meetingTimes",meetingTimes);
        model.addAttribute("periods",meetingService.findAll());
        return "periods";
    }

    @PostMapping("/save")
    public String newTime(@ModelAttribute("save") MeetingTimes meetingTimes, Model model, RedirectAttributes redirectAttributes){
        String name,message;
        meetingService.createMeetingTime(meetingTimes);
        message = " Meeting Time is successfully Saved";
        redirectAttributes.addFlashAttribute("data", message);
        redirectAttributes.addFlashAttribute("message", "success");
        return "redirect:/admin/periods";
    }
}
