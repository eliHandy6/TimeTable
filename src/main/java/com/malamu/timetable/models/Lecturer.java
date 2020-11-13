package com.malamu.timetable.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "lecturer_tbl")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String idNo;
    private String name;
    private String email;



}
