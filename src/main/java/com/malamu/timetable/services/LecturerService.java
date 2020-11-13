package com.malamu.timetable.services;

import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.repositories.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    //CRUD

    @Transactional
    public Lecturer createLecturer(Lecturer lecturer){
        return lecturerRepository.save(lecturer);
    }

    @Transactional
    public List<Lecturer> findLecturers(){
        return lecturerRepository.findAll();
    }
    @Transactional
    public Lecturer findLecturerById(int id){
        return lecturerRepository.findById(id).get();
    }

    @Transactional
    public Lecturer updateLecturer(int id,Lecturer lecturer){
     Lecturer lecturer1 =lecturerRepository.findById(id).get();
     lecturer1.setIdNo(lecturer.getIdNo());
     lecturer1.setName(lecturer.getName());
     lecturer1.setEmail(lecturer.getEmail());
     return lecturerRepository.save(lecturer1);
    }

    @Transactional
    public void deleteLecturer(int id){
        lecturerRepository.deleteById(id);
    }




}
