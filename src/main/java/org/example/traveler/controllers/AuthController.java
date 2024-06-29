package org.example.traveler.controllers;

import org.example.traveler.dtos.authDtos.RegisterDto;
import org.example.traveler.dtos.guideDtos.GuideDetailDto;
import org.example.traveler.dtos.userDtos.UserDetailDto;
import org.example.traveler.dtos.userDtos.UserUpdateDto;
import org.example.traveler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "/pages/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/pages/register";
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto){
        boolean res = userService.register(registerDto);
        if (res == false){
            return "register";
        }
        return "redirect:/login";
    }

    @GetMapping("/auth/confirm")
    public String confirm(String email,String token){
//        boolean res = userService.confirmEmail(email,token);
        userService.confirmEmail(email,token);

        return "redirect:/login";
    }

    @GetMapping("/user")
        public String userDetail(Model model, Principal principal){
        String username = principal.getName();
        UserDetailDto userDetailDto = userService.getByEmail(username);
        model.addAttribute("user",userDetailDto);
        return "/pages/user-page/user-detail";
    }

    @GetMapping("/user/update/{id}")
    public String userUpdate(@PathVariable Long id, Model model){
        UserUpdateDto userUpdateDto = userService.findUpdateUser(id);
        model.addAttribute("user",userUpdateDto);
        return "/pages/user-page/user-update";
    }
    @PostMapping("/user/update")
    public String userUpdate(@ModelAttribute UserUpdateDto userUpdateDto){
        userService.updateUser(userUpdateDto);
        return "redirect:/admin";
    }
}
