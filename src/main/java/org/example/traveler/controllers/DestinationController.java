package org.example.traveler.controllers;

import org.example.traveler.dtos.destinationDtos.DestinationDetailDto;
import org.example.traveler.dtos.destinationDtos.DestinationsPageDto;
import org.example.traveler.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;
    
    @GetMapping("/destinations")
    public String destinations(Model model){
        List<DestinationsPageDto> destinationsPageDtos = destinationService.getDestinationPagesDto();
        model.addAttribute("destinations",destinationsPageDtos);
        return "/pages/destination-page/destinations";
    }
    @GetMapping("/destinations/{id}")
    public String destinations(@PathVariable Long id, Model model){
        DestinationDetailDto destination = destinationService.getDestinationDetail(id);
        model.addAttribute("destination",destination);
        return "/pages/destination-page/destination-detail";
    }
}
