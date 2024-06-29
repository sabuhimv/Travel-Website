package org.example.traveler.services.impls;

import org.example.traveler.dtos.destinationDtos.DestinationCreateDto;
import org.example.traveler.dtos.destinationDtos.DestinationDetailDto;
import org.example.traveler.dtos.destinationDtos.DestinationDto;
import org.example.traveler.dtos.destinationDtos.DestinationsPageDto;
import org.example.traveler.models.Destination;
import org.example.traveler.repositories.DestinationRepository;
import org.example.traveler.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void add(DestinationCreateDto destinationCreateDto) {
        Destination destination = modelMapper.map(destinationCreateDto, Destination.class);
        destinationRepository.save(destination);
    }

    @Override
    public List<DestinationDto> getAllDestinations() {
        List<DestinationDto> destinations = destinationRepository.findAll().stream()
                .map(destination -> modelMapper.map(destination,DestinationDto.class)).collect(Collectors.toList());
        return destinations;
    }

    @Override
    public List<DestinationsPageDto> getDestinationPagesDto() {
        List<DestinationsPageDto> destinationsPageDtos = destinationRepository.findAll().stream()
                .map(destination -> modelMapper.map(destination,DestinationsPageDto.class)).collect(Collectors.toList());
        return destinationsPageDtos;
    }

    @Override
    public DestinationDetailDto getDestinationDetail(Long id) {
        DestinationDetailDto destinationDetailDto = destinationRepository.findById(id).map(destination -> modelMapper.map(destination,DestinationDetailDto.class)).orElseThrow();
        return destinationDetailDto;
    }

}
