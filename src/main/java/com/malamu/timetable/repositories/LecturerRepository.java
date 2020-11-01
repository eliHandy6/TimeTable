package com.malamu.timetable.repositories;

import com.malamu.timetable.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository  extends JpaRepository<Lecturer,Integer> {
}
