package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.services.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/lecturers/find")
@AllArgsConstructor
public class LecturerRest {

    private LecturerService lecturerService;

    @GetMapping
    public List<Lecturer> getAllLecs(){
        return lecturerService.findLecturers();
    }
}
