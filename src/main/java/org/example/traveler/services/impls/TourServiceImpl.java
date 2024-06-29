package org.example.traveler.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.traveler.dtos.tourDtos.TourCreateDto;
import org.example.traveler.dtos.tourDtos.TourDto;
import org.example.traveler.models.Destination;
import org.example.traveler.models.Guide;
import org.example.traveler.models.Tour;
import org.example.traveler.repositories.DestinationRepository;
import org.example.traveler.repositories.GuideRepository;
import org.example.traveler.repositories.TourRepository;
import org.example.traveler.services.TourService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceImpl implements TourService {

    private final DestinationRepository destinationRepository;
    private final TourRepository tourRepository;
    private final ModelMapper modelMapper;
    private final GuideRepository guideRepository;

    @Override
    public List<TourDto> getTours() {
        List<TourDto> tourDtos = tourRepository.findAll().stream()
                .map(tour -> modelMapper.map(tour, TourDto.class))
                .collect(Collectors.toList());

        return tourDtos;
    }

    @Override
    public void addTour(TourCreateDto tourCreateDto) {
        Tour tour = new Tour();
        tour.setId(tourCreateDto.getId());
        tour.setName(tourCreateDto.getName());
        tour.setDescription(tourCreateDto.getDescription());
        tour.setPrice(tour.getPrice());
//        tour.setDepartDate(tourCreateDto.getDepartDate());
//        tour.setReturnDate(tourCreateDto.getReturnDate());
        tour.setDuration(tour.getDuration());
        tour.setTourImage(tourCreateDto.getTourImage());



//        tourRepository.saveAndFlush(tour);

//        List<Destination> destinations = new ArrayList<>();
//        for (Long id : tourCreateDto.getDestinationIds()){
//            Destination destination=destinationRepository.findById(id).orElseThrow();
//            destinations.add(destination);
//        }
//        tour.setDestinations(destinations);

//        Guide guide = guideRepository.findById(tourCreateDto.getGuide().getId())
//                .orElseThrow(() -> new RuntimeException("Not found guide"));
//        tour.setGuide(guide);

        tourRepository.saveAndFlush(tour);

    }
}
