package org.example.traveler.dtos.tourDtos;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.example.traveler.dtos.destinationDtos.DestinationCreateDto;
import org.example.traveler.dtos.destinationDtos.DestinationDto;
import org.example.traveler.dtos.guideDtos.GuideCreateDto;
import org.example.traveler.dtos.guideDtos.GuideDto;
import org.example.traveler.models.Destination;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class TourCreateDto {
    private Long id;
    private String name;
    private String description;
    private String price;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date departDate;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date returnDate;

    private String duration;
    private String maxParticipants;
    private String tourImage;
//    private List<Long> destinationIds;
//    private GuideDto guide;
}
