package org.example.traveler.dtos.testimonialDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialCreateDto {
    private Long id;
    private String name;
    private String surname;
    private String profession;
    private String comment;
    private String photo;
}
