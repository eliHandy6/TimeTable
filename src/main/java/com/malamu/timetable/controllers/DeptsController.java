package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Depts;
import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.models.MeetingTimes;
import com.malamu.timetable.models.Units;
import com.malamu.timetable.repositories.DeptsRepository;
import com.malamu.timetable.services.CourseService;
import com.malamu.timetable.services.DeptServices;
import com.malamu.timetable.services.UnitsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/admin/depts")
@AllArgsConstructor
public class DeptsController {

    private  final DeptServices deptServices;
    private  final DeptsRepository deptsRepository;
    private final UnitsService unitsService;

    @GetMapping
    public String depts(Model model, RedirectAttributes redirectAttributes){
        Depts  depts=new Depts();
        model.addAttribute("department",depts);
        model.addAttribute("units",unitsService.findAllUnits());
        return "departments";
    }


    @PostMapping("/save")
    public String newDepartment(@ModelAttribute("save") Depts depts, Model model, RedirectAttributes redirectAttributes){
        String message;

        Optional<Depts> existingDept=deptsRepository.findByName(depts.getName());
        if(existingDept.isPresent()){
            message = " Department " + depts.getName() + " is existing ";
            redirectAttributes.addFlashAttribute("data", message);
            redirectAttributes.addFlashAttribute("message", "failed");
        }
        else{
             Depts created=deptServices.createDept(depts);
             String units=depts.getUnit();
             String unitNames[]= units.split(",");
            for (String temp: unitNames){
                Units unit=new Units(created,temp);
                unitsService.createUnit(unit);
            }
        message = " Department  " + depts.getName() + "  and its units are successfully Saved";
        redirectAttributes.addFlashAttribute("data", message);
        redirectAttributes.addFlashAttribute("message", "success");
        }
        return "redirect:/admin/depts";
    }

}
