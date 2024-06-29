package org.example.traveler.controllers;

import org.example.traveler.dtos.destinationDtos.DestinationsPageDto;
import org.example.traveler.dtos.tourDtos.TourDto;
import org.example.traveler.repositories.TourRepository;
import org.example.traveler.services.DestinationService;
import org.example.traveler.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TourController {
    @Autowired
    private TourService tourService;

    @Autowired
    private DestinationService destinationService;



    @GetMapping("/tours")
    public String tours(Model model){
        List<TourDto> tourDtos= tourService.getTours();
        List<DestinationsPageDto> destinationsPageDtos = destinationService.getDestinationPagesDto();

        model.addAttribute("destinations",destinationsPageDtos);
        model.addAttribute("tours",tourDtos);
        return "/pages/tour-page/tours";
    }

}
