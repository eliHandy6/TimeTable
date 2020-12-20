package com.malamu.timetable.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Payload {
   private long department;
   private ArrayList<DetailsDTO> course_details;
}
