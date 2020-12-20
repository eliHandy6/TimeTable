package com.malamu.timetable.repositories;

import com.malamu.timetable.models.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitsRepository extends JpaRepository<Units,Integer> {

    List<Units> findByDeptsId(int id);
}
