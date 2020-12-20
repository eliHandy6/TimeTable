/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malamu.timetable.models.timetablealgorithm;

import com.malamu.timetable.models.Depts;
import com.malamu.timetable.models.Class;

import java.util.ArrayList;


/**
 *
 * @author Jexi
 */

public class Schedule {
    
    private ArrayList<Class> classes;


    private boolean isFitnessChanged = true;
    private double fitness = -1;
    //define the class no counter
    private int classNumb = 0;
    //uses data coming from the data class
    private Data data;
    //define the number of conflicts
    private int numbofConflicts = 0;



    public Data getData() {
        return data;
    }

    public Schedule(Data data) {
         this.data = data;
        
        classes = new ArrayList<Class>(data.getNumberofClasses());
        
    }












    //use the instance variable as an initialized method
    public Schedule initialize(){
        
        new ArrayList<Depts>(data.getDepts()).forEach(dept ->{
        dept.getCourses().forEach(course ->{
        Class newClass = new Class(classNumb++,dept,course);
        
        //set the meetingtime randomly
       newClass.setMeetingTimes(data.getMeetingTimes().get((int) (data.getMeetingTimes().size()* Math.random())));
       newClass.setRoom(data.getRooms().get((int) (data.getRooms().size()* Math.random())));
       newClass.setInstructor(data.getInstructor().get((int) (data.getInstructor().size()* Math.random())));
       classes.add(newClass);
    });
    });
        return this;
    }

    public int getNumbofConflicts() {
        return numbofConflicts;
    }

    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }
    

    public double getFitness() {
        
        if(isFitnessChanged == true){
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }
    
    public double calculateFitness() {
        
        numbofConflicts = 0;
        classes.forEach(x -> {
            if(x.getRoom().getSeatingCapasity()< x.getCourse().getNoOfStudents()) numbofConflicts++;
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
              if(x.getMeetingTimes() == y.getMeetingTimes() && x.getId() != y.getId()) {
                if(x.getRoom() == y.getRoom()) numbofConflicts++;
                if(x.getInstructor() == y.getInstructor()) numbofConflicts++;
                }
            });
        });
        
        return 1/(double)(numbofConflicts+1);
    }
    public String toString(){
        String returnValue = new String();
        
        for(int x = 0; x < classes.size()-1; x++) returnValue += classes.get(x)+ ",";
        returnValue += classes.get(classes.size()-1);
        return returnValue;
    }
    
}
