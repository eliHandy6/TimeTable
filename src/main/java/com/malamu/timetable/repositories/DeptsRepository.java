package com.malamu.timetable.repositories;

import com.malamu.timetable.models.Depts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptsRepository  extends JpaRepository<Depts,Integer> {
}
