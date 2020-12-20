package com.malamu.timetable.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Entity(name = "course_tbl")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "depts_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JsonManagedReference
    private Depts depts;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Units units;

    private int noOfStudents;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lecturer lecturer;

    public Course(Depts depts, Lecturer lecturer, Units units, int no) {

        this.depts=depts;
        this.lecturer=lecturer;
        this.units=units;
        this.noOfStudents=no;
    }
}
