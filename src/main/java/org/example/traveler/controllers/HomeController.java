package org.example.traveler.controllers;

import org.example.traveler.dtos.destinationDtos.DestinationsPageDto;
import org.example.traveler.dtos.guideDtos.GuidePersonalDto;
import org.example.traveler.dtos.testimonialDtos.TestimonialDto;
import org.example.traveler.services.DestinationService;
import org.example.traveler.services.GuideService;
import org.example.traveler.services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private GuideService guideService;

    @Autowired
    private TestimonialService testimonialService;


    @GetMapping("/")
    public String index(Model model){
        List<DestinationsPageDto> destinations = destinationService.getDestinationPagesDto();
        List<GuidePersonalDto> teamGuides = guideService.getTeamGuides();
        List<TestimonialDto> testimonials = testimonialService.getAllEnableTestimonials();

        model.addAttribute("destinations",destinations);
        model.addAttribute("teamGuides",teamGuides);
        model.addAttribute("testimonials",testimonials);

        return "home";
    }
}