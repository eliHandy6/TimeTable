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
        return deptsRepository.save(depts);
    }
    @Transactional
    public List<Depts> findAllDepts(){
        return deptsRepository.findAll();
    }

    @Transactional
    public Depts findDeptbyId(int id){
        return deptsRepository.findById(id).get();
    }








}
