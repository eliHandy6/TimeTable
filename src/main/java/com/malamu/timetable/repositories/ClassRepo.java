package com.malamu.timetable.repositories;

import com.malamu.timetable.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepo extends JpaRepository<Class,Integer> {

    List<Class> findByTimetableNamesId(int i);
}
