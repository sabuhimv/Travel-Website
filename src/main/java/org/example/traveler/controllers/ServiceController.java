package org.example.traveler.controllers;

import org.example.traveler.dtos.testimonialDtos.TestimonialDto;
import org.example.traveler.services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    private TestimonialService testimonialService;

    @GetMapping("/services")
    public String services(Model model){
        List<TestimonialDto> testimonials = testimonialService.getAllEnableTestimonials();
        model.addAttribute("testimonials",testimonials);
        return "/pages/services-page/services";
    }
}
