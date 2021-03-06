package com.malamu.timetable.controllers;

import com.malamu.timetable.models.TimetableDao;
import com.malamu.timetable.models.TimetableNames;
import com.malamu.timetable.repositories.TimetableRepository;
import com.malamu.timetable.services.CourseService;
import com.malamu.timetable.services.DeptServices;
import com.malamu.timetable.services.LecturerService;
import com.malamu.timetable.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class DashboardController {

    private final LecturerService lecturerService;
    private final CourseService courseService;
    private final RoomService roomService;
    private final DeptServices deptServices;
    private final TimetableRepository timetableRepository;

    @GetMapping
    public String dashboard(Model model, RedirectAttributes redirectAttributes){
        TimetableDao timetableDao=new TimetableDao();
        model.addAttribute("department",timetableDao);
        model.addAttribute("timetablenames",timetableRepository.findAll());
        return "dashboard";
    }


}
