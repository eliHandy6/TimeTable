package com.malamu.timetable.services;

import com.malamu.timetable.models.Room;
import com.malamu.timetable.models.Units;
import com.malamu.timetable.repositories.RoomRepository;
import com.malamu.timetable.repositories.UnitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitsService {

    private final UnitsRepository unitsRepository;

    //CRUD

    @Transactional
    public Units createUnit(Units  unit){
        return unitsRepository.save(unit);
    }

    @Transactional
    public Units findById(int id){
        return unitsRepository.findById(id).get();
    }
    @Transactional
    public List<Units> findAllUnits( ){
        return unitsRepository.findAll();
    }



}
