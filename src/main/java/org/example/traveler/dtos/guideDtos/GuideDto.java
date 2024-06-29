package org.example.traveler.dtos.guideDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuideDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String biography;
    private String photoUrl;
    private Boolean isDeleted = false;
}
