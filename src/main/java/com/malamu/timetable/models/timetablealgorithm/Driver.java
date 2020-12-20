/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malamu.timetable.models.timetablealgorithm;

import java.util.ArrayList;
import java.util.List;

import com.malamu.timetable.models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jexi
 */

@Service
public class Driver {
    
   public static final int POPULATION_SIZE = 9;
   public static final double MUTATION_RATE = 0.1;
   public static final double CROSSOVER_RATE = 0.9;
   public static final int TOURNAMENT_SELECTION_SIZE = 1;
   public static final int NUMB_OF_ELITE_SCHEDULES = 1;
   private int scheduleNumb =0;
   private int classNumb = 1;

   @Autowired
   Data data;
   
   public Schedule tryStuff(int id){
       Driver driver = new Driver();
       try {
            driver.data = data.initialize(id);
            int generationNumber = 0;
           driver.printAvailableData();
           System.out.println("> Generation #"+generationNumber);
           System.out.println(" Schedule # |                   ");
           System.out.println("Classes [dept,class,room,instructor,meeting-time]");
           System.out.println("                   |Fitness| Conflicts");
           System.out.println("--------------------------------");
           System.out.println("----------------------------------");
           GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
           Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
           Schedule schedule =  population.getSchedules().get(0);

//           population.getSchedules().forEach(schedule -> System.out.println("  "+driver.scheduleNumb++ +"  |"+schedule.getClasses()+" | "+ String.format("%.5f", schedule.getFitness()) +" | "+schedule.getNumbofConflicts()));
//          driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
           return schedule;
//           population.getSchedules().forEach(schedule -> System.out.println("  "+driver.scheduleNumb++ +"  |"+schedule.getClasses()+" | "+ String.format("%.5f", schedule.getFitness()) +" | "+schedule.getNumbofConflicts()));
//           driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
       } catch (Exception e) {
          e.printStackTrace();
       }

       return null;
   }
   private void printScheduleAsTable(Schedule schedule,int generation){

       ArrayList<Class> classes = schedule.getClasses();
       System.out.println("\n        ");
       System.out.println("Class # | Dept | Course (number , max # of students) | Room(capacity) | Instructor (Id) | Meeting Time (Id)");
       System.out.println("               ");
       System.out.println("-----------------------------");
       System.out.println("-------------------------------");
       classes.forEach(x ->{

           int majorIndex = data.getDepts().indexOf(x.getDept());
           int courseIndex = data.getCourses().indexOf(x.getCourse());
           int roomsIndex = data.getRooms().indexOf(x.getRoom());
           int instructorsIndex = data.getInstructor().indexOf(x.getInstructor());
           int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTimes());
           System.out.print("            ");
           System.out.print(String.format(" %1$02d", classNumb)+ " | ");
           System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName())+"  |  ");
           System.out.print(String.format("%1$21s", data.getCourses().get(courseIndex).getId()+"("+data.getCourses().get(courseIndex).getUnits().getUnitName()+","+x.getCourse().getNoOfStudents())+") |");
           System.out.print(String.format("%1$10s", data.getRooms().get(roomsIndex).getNumber()+"("+x.getRoom().getSeatingCapasity())+") |");
           System.out.print(String.format("%1$15s", data.getInstructor().get(instructorsIndex).getName()+"("+data.getInstructor().get(instructorsIndex).getId()+")")+"    |");
           System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getStartTime()+"-"+data.getMeetingTimes().get(meetingTimeIndex).getEndTime()+"("+data.getMeetingTimes().get(meetingTimeIndex).getId()+")");
           classNumb++;

       });
       if(schedule.getFitness()==1) System.out.println(">Solution Found in "+(generation+1)+" generations");
       System.out.println("---------------------------------------");
       System.out.println("-------------------------------------------------");
       
   }
   private void printAvailableData(){
       System.out.println("Available Departments ==>");
       data.getDepts().forEach(x->System.out.println("name: "+x.getName()+",courses: "));
       System.out.println("\nAvailable Courses ==>");
       data.getCourses().forEach(x -> System.out.println("course #:"+x.getId()+", name: "+x.getUnits().getUnitName()+", max # of students:"+ x.getNoOfStudents()+",instructors: "+ x.getLecturer().getName()));
       System.out.println("\nAvailable Rooms ==>");
       data.getRooms().forEach(x ->System.out.println("room #:"+x.getNumber()+", max seating capacity:"+x.getSeatingCapasity()));
       System.out.println("\nAvailable Instructors ==>");
       data.getInstructor().forEach(x->System.out.println("id: "+x.getId()+",name: "+x.getName()));
       System.out.println("\nAvailable Meeting Times ==>");
       data.getMeetingTimes().forEach(x->System.out.println("id: "+x.getId()+",Meeting Time:"+x.getStartTime()));
       System.out.println("--------------------------------");
       System.out.println("----------------------------");
   }
    
}
