package com.malamu.timetable.repositories;

import com.malamu.timetable.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course>  findByDeptsId(int id);
}
