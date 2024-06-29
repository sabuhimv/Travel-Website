package org.example.traveler.controllers;

import org.example.traveler.dtos.guideDtos.GuidePersonalDto;
import org.example.traveler.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private GuideService guideService;

    @GetMapping("/about")
    public String about(Model model){
        List<GuidePersonalDto> teamGuides = guideService.getTeamGuides();
        model.addAttribute("teamGuides",teamGuides);
        return "about";
    }

}
