package com.malamu.timetable.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DetailsDTO {
    long lecturer;
    long no_of_students;
    long unit_id;
}
