package com.malamu.timetable.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "timetablenames_tbl")
@Data
@NoArgsConstructor
public class TimetableNames {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String names;

    public TimetableNames(String names) {
        this.names=names;

    }
}
