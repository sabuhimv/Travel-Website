package org.example.traveler.dtos.destinationDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationDto {
    private Long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private String photoUrl;
}

