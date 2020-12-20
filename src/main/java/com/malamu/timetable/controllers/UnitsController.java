package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Units;
import com.malamu.timetable.repositories.UnitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/units")
@AllArgsConstructor
public class UnitsController {

    private final UnitsRepository unitsRepository;

    @PostMapping("/{id}")
    public List<Units> findbyDept(@PathVariable("id") int id){
        System.out.println(id);
        return unitsRepository.findByDeptsId(id);
    }
}
