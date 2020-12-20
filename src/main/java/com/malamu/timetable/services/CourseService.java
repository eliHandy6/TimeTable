package com.malamu.timetable.services;


import com.malamu.timetable.models.Course;
import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final LecturerService lecturerService;

    //CRUD

    @Transactional
    public Course createCourse(Course  course){
        Lecturer lecturer=lecturerService.findLecturerById(course.getLecturer().getId());
        course.setLecturer(lecturer);
        return courseRepository.save(course);
    }

    @Transactional
    public  Course findCourseById(int id){
       return courseRepository.findById(id).get();
    }
    @Transactional
    public  List<Course> findByDeptId(int id){
//        System.out.println("Hello"+id);
        return courseRepository.findByDeptsId(id);
    }

    @Transactional
    public List<Course> findAvailableCourses(){
        return courseRepository.findAll();
    }
    @Transactional
    public Course updateCourse(int id,Course  course){

        Lecturer lecturer=lecturerService.findLecturerById(course.getLecturer().getId());

        Course course1=courseRepository.findById(id).get();
//        course1.setName(course.getName());
//        course1.setNumber(course.getNumber());
        course1.setNoOfStudents(course.getNoOfStudents());
        course1.setLecturer(lecturer);
        return courseRepository.save(course1);
    }

    @Transactional
    public void deleteCourse(int id){
        courseRepository.deleteById(id);
    }
}
