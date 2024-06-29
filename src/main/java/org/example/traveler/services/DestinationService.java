package org.example.traveler.services;

import org.example.traveler.dtos.destinationDtos.DestinationCreateDto;
import org.example.traveler.dtos.destinationDtos.DestinationDetailDto;
import org.example.traveler.dtos.destinationDtos.DestinationDto;
import org.example.traveler.dtos.destinationDtos.DestinationsPageDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DestinationService {
    void add (DestinationCreateDto destinationCreateDto);
    List<DestinationDto> getAllDestinations();
    List<DestinationsPageDto> getDestinationPagesDto();
    DestinationDetailDto getDestinationDetail(Long id);
}
