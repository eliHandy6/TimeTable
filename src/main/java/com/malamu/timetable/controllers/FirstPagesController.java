package com.malamu.timetable.controllers;

import com.malamu.timetable.models.Role;
import com.malamu.timetable.models.TimetableDao;
import com.malamu.timetable.models.TimetableNames;
import com.malamu.timetable.models.Users;
import com.malamu.timetable.repositories.ClassRepo;
import com.malamu.timetable.repositories.RoleRepository;
import com.malamu.timetable.repositories.TimetableRepository;
import com.malamu.timetable.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLOutput;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FirstPagesController {

    private  final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TimetableRepository timetableRepository;
    private final ClassRepo classRepo;


    private final  BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String login(){
        return "AdminLogin";
    }


    @GetMapping("/studentReg")
    public String regstudent(Model model){
        Users user=new Users();
        model.addAttribute("user",user);
        return "sinLog";
    }

    @PostMapping("/studentSave/save")
    public String saveStudent(Model model, @ModelAttribute("save") Users users, RedirectAttributes redirectAttributes){
        Optional<Users> users1=userRepository.findByEmail(users.getEmail());

        if(users1.isPresent()){
            redirectAttributes.addFlashAttribute("data", "The Username is Existing");
        }
        else{
            Optional<Role> role=roleRepository.findByName("student");
            if(role.isPresent()){
                users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
                users.setRole(role.get());
                userRepository.save(users);
                return "redirect:/student/viewTimetables";
            }

        }
        return "redirect:/studentReg";

    }

    @GetMapping("/student/viewTimetables")
     public String findTimetables(Model model){
        TimetableDao timetableDao=new TimetableDao();
        model.addAttribute("department",timetableDao);
        model.addAttribute("timetablenames",timetableRepository.findAll());
        return "studentPage";
     }

    @PostMapping("/student/viewTimetables/view")
    public String viewTime(Model model, @ModelAttribute("save") TimetableDao timetableDao){
        TimetableNames timetableNames=timetableRepository.findById(timetableDao.getId()).get();
        model.addAttribute("timetablename",timetableNames);
        model.addAttribute("classes",classRepo.findByTimetableNamesId(timetableDao.getId()));
        return  "display2";
    }




    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
