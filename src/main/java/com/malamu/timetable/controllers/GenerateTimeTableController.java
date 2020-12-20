package com.malamu.timetable.controllers;

import com.malamu.timetable.models.*;
import com.malamu.timetable.models.Class;
import com.malamu.timetable.models.timetablealgorithm.Driver;
import com.malamu.timetable.models.timetablealgorithm.Schedule;
import com.malamu.timetable.repositories.ClassRepo;
import com.malamu.timetable.repositories.TimetableRepository;
import com.malamu.timetable.services.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/generatetimetable")
@AllArgsConstructor
public class GenerateTimeTableController {

private final Driver driver;
private final ClassRepo classRepo;
private final TimetableRepository timetableRepository;


@PostMapping("/save")
public String generateTime(Model model, @ModelAttribute("save") TimetableDao timetableDao){

    TimetableNames timetableNames=new TimetableNames(timetableDao.getName());
    TimetableNames abc=timetableRepository.save(timetableNames);
    Schedule a=  driver.tryStuff(timetableDao.getId());
    ArrayList<Class> classes = a.getClasses();
    for (Class aClass:classes) {
        aClass.setTimetableNames(abc);
        classRepo.save(aClass);
    }
    model.addAttribute("classes",classes);
    model.addAttribute("timetablename",abc);
    return  "display";
}

    @PostMapping("/view")
    public String viewTime(Model model, @ModelAttribute("save") TimetableDao timetableDao){
        TimetableNames timetableNames=timetableRepository.findById(timetableDao.getId()).get();
        model.addAttribute("timetablename",timetableNames);
        model.addAttribute("classes",classRepo.findByTimetableNamesId(timetableDao.getId()));
        return  "display";
    }





}
