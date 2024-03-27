package com.cydeo.controller;

import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class LabController {

    @RequestMapping("/lab")
    public String labInfo(Model model){
model.addAttribute("firstLab","lab-01-Coupling");
model.addAttribute("secondLab","lab-02-IoC");
model.addAttribute("thirdLab","lab-03-DI");
model.addAttribute("fourthLab","lab-04-Spring Boot");
model.addAttribute("fifthLab","lab-05-Spring MVC");
        return "lab/lab-list";
    }
    @RequestMapping("/profile")
    public String profileInfo(Model model){
        Profile profile = new Profile("John", "Doe", "01234566789", "johndoe@cydeo.com", "1234567", LocalDateTime.now());
        model.addAttribute(profile);
        return "profile/profile-info";
    }

    @RequestMapping("/login/{email}/{phoneNumber}")
    public String carInfo(@PathVariable String email, @PathVariable String phoneNumber, Model model){

        model.addAttribute("email", email);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("loginMessage", "Login successful");

        return "login/login-info";
    }

    /*
    email@email.com
    0123456789
    Login successful
     */

}
