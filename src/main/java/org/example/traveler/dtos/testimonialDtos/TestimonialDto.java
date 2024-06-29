package org.example.traveler.dtos.testimonialDtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestimonialDto {
    private Long id;
    private String name;
    private String surname;
    private String profession;
    private String comment;
    private String photo;
    private Date createdDate;
}
