package org.example.traveler.controllers;

import org.example.traveler.dtos.guideDtos.GuideDetailDto;
import org.example.traveler.dtos.guideDtos.GuidePersonalDto;
import org.example.traveler.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping("/guides")
    public String guides(Model model){
        List<GuidePersonalDto> teamGuides = guideService.getTeamGuides();
        model.addAttribute("teamGuides",teamGuides);
        return "/pages/guide-page/teamGuides";
    }

    @GetMapping("/guides/{id}")
    public String guideDetail(@PathVariable Long id, Model model){
        GuideDetailDto guideDetailDto = guideService.guideDetail(id);
        model.addAttribute("guideDetail",guideDetailDto);
        return "/pages/guide-page/guide-detail";
    }
}
