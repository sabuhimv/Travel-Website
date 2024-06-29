package org.example.traveler.services;


import org.example.traveler.dtos.testimonialDtos.TestimonialCreateDto;
import org.example.traveler.dtos.testimonialDtos.TestimonialDto;

import java.util.List;

public interface TestimonialService {
    void createTestimonial(TestimonialCreateDto testimonialCreateDto);
    List<TestimonialDto> getAllEnableTestimonials();


}
