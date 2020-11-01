package com.malamu.timetable.controllers;

import com.malamu.timetable.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("rooms",roomService.findAvailableRooms());
        return "rooms";
    }

}
