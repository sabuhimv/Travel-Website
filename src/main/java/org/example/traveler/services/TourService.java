package org.example.traveler.services;

import org.example.traveler.dtos.tourDtos.TourCreateDto;
import org.example.traveler.dtos.tourDtos.TourDto;
import org.example.traveler.models.Guide;

import java.util.List;

public interface TourService {
    List<TourDto> getTours();
    void addTour(TourCreateDto tourCreateDto);
//    void addTour(TourCreateDto tourCreateDto, List<Long> destinationIds, List<Guide> guides);
}
