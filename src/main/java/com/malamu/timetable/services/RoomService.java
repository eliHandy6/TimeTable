package com.malamu.timetable.services;

import com.malamu.timetable.models.Room;
import com.malamu.timetable.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    //CRUD

    @Transactional
    public Room createRoom(Room  room){
        return roomRepository.save(room);
    }

    @Transactional
    public List<Room> findAvailableRooms(){
        return roomRepository.findAll();
    }
    @Transactional
    public Room updateRoom(int id,Room  room){
        Room room1=roomRepository.findById(id).get();
        room1.setNumber(room.getNumber());
        room1.setSeatingCapasity(room.getSeatingCapasity());
        return roomRepository.save(room1);
    }

    @Transactional
    public void deleteRoom(int id){
        roomRepository.deleteById(id);
    }


}
