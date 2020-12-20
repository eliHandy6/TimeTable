package com.malamu.timetable.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity(name = "units_tbl")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String unitName;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Depts depts;

    public Units(Depts createddept, String temp) {
        this.depts=createddept;
        this.unitName=temp;
    }
}
