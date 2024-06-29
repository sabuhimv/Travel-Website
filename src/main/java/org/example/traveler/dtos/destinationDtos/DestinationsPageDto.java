package org.example.traveler.dtos.destinationDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationsPageDto {
    private Long id;
    private String name;
    private String city;
    private String photoUrl;
}
