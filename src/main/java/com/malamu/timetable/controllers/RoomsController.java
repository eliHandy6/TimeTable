package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Lecturer;
import com.malamu.timetable.models.Room;
import com.malamu.timetable.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/rooms")
@AllArgsConstructor
public class RoomsController {

    private final RoomService roomService;

    @GetMapping
    public String rooms(Model model, RedirectAttributes redirectAttributes){
        Room room=new Room();
        model.addAttribute("room",room);
        model.addAttribute("rooms",roomService.findAvailableRooms());
        return "rooms";
    }
    @PostMapping("/save")
    public String newRoom(@ModelAttribute("save") Room room, Model model, RedirectAttributes redirectAttributes){
        String name,message;
        roomService.createRoom(room);
        message = " Room " + room.getNumber()+ " is successfully Saved";
        redirectAttributes.addFlashAttribute("data", message);
        redirectAttributes.addFlashAttribute("message", "success");
        return "redirect:/admin/rooms";
    }

}
