package org.example.traveler.dtos.tourDtos;

import lombok.Getter;
import lombok.Setter;
import org.example.traveler.dtos.destinationDtos.DestinationDto;
import org.example.traveler.dtos.guideDtos.GuideDto;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TourDto {
    private Long id;
    private String name;
    private String description;
    private String price;
//    private Date departDate;
//    private Date returnDate;
    private String duration;
    private String maxParticipants;
    private String tourImage;
//    private List<DestinationDto> destinations;
//    private GuideDto guide;
}
