package org.example.traveler.services.impls;

import org.example.traveler.dtos.testimonialDtos.TestimonialCreateDto;
import org.example.traveler.dtos.testimonialDtos.TestimonialDto;
import org.example.traveler.models.Testimonial;
import org.example.traveler.repositories.TestimonialRepository;
import org.example.traveler.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {
    @Autowired
    private TestimonialRepository testimonialRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createTestimonial(TestimonialCreateDto testimonialCreateDto) {
        Testimonial testimonial = modelMapper.map(testimonialCreateDto,Testimonial.class);
        Date date=new Date();
        testimonial.setCreatedDate(date);
        testimonialRepository.saveAndFlush(testimonial);
    }

    @Override
    public List<TestimonialDto> getAllEnableTestimonials() {
        return testimonialRepository.findAll().stream()
                .map(testimonial -> modelMapper.map(testimonial,TestimonialDto.class)).collect(Collectors.toList());
    }
}
