package com.malamu.timetable.services;

import com.malamu.timetable.models.Course;
import com.malamu.timetable.models.Depts;
import com.malamu.timetable.repositories.DeptsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DeptServices {
    private final DeptsRepository deptsRepository;
    private  final CourseService courseService;

    //CRUD
    @Transactional
    public Depts createDept(Depts depts){
        Course course=courseService.findCourseById(depts.getCourse().getId());
        depts.setCourse(course);
        return deptsRepository.save(depts);
    }
    @Transactional
    public List<Depts> findAllDepts(){
        return deptsRepository.findAll();
    }
    @Transactional
    public Depts updateDept(int id,Depts depts){
        Depts depts1=deptsRepository.findById(id).get();
        Course course=courseService.findCourseById(depts.getCourse().getId());
        depts1.setName(depts.getName());
        depts1.setCourse(course);
        return deptsRepository.save(depts1);
    }





}
