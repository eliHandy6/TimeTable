package com.malamu.timetable.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "depts_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Depts dept;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Course course;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "lec_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lecturer instructor;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "meet_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    private MeetingTimes meetingTimes;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Room room;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "timetableNames_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TimetableNames timetableNames;

    public Class(int i, Depts dept, Course course) {
        this.id=i;
        this.dept=dept;
        this.course=course;
    }

    public Class(int i, Depts dept, Units units) {

        this.id=i;
        this.dept=dept;
//        this.units=units;
    }
}
