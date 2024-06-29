package org.example.traveler.services.impls;

import org.example.traveler.dtos.guideDtos.*;
import org.example.traveler.models.Guide;
import org.example.traveler.repositories.DestinationRepository;
import org.example.traveler.repositories.GuideRepository;
import org.example.traveler.services.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private GuideRepository guideRepository ;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addGuide(GuideCreateDto guideCreateDto) {
        Guide guide = modelMapper.map(guideCreateDto,Guide.class);
        guideRepository.saveAndFlush(guide);
    }

    @Override
    public List<GuideDto> getAllActiveGuides() {
        List<GuideDto> guides = guideRepository.findAll().stream()
                .filter(guide -> !guide.getIsDeleted())
                .map(guide -> modelMapper.map(guide,GuideDto.class)).collect(Collectors.toList());
        return guides;
    }

    @Override
    public List<GuideDto> getAllGuides() {
        List<GuideDto> guides = guideRepository.findAll().stream().map(guide -> modelMapper.map(guide,GuideDto.class)).collect(Collectors.toList());
        return guides;
    }

    @Override
    public void removeGuide(Long id) {
        Guide guide = guideRepository.findById(id).orElseThrow();
        guide.setIsDeleted(!guide.getIsDeleted());
        guideRepository.saveAndFlush(guide);
    }

    @Override
    public List<GuidePersonalDto> getTeamGuides() {
        List<GuidePersonalDto> guides = guideRepository.findAll().stream()
                .filter(guide-> !guide.getIsDeleted())
                .map(guide -> modelMapper.map(guide,GuidePersonalDto.class)).collect(Collectors.toList());
        return guides;
    }

    @Override
    public GuideDetailDto guideDetail(Long id) {
        Guide guide = guideRepository.findById(id).orElseThrow();
        return modelMapper.map(guide,GuideDetailDto.class);
    }

    @Override
    public GuideUpdateDto findUpdateGuide(Long id) {
        Guide guide = guideRepository.findById(id).orElseThrow();
        GuideUpdateDto guideUpdateDto = modelMapper.map(guide, GuideUpdateDto.class);
        return guideUpdateDto;
    }

    @Override
    public void updateGuide(GuideUpdateDto guideUpdateDto) {
        Guide findGuide = guideRepository.findById(guideUpdateDto.getId()).orElseThrow();
        findGuide.setId(guideUpdateDto.getId());
        findGuide.setName(guideUpdateDto.getName());
        findGuide.setEmail(guideUpdateDto.getEmail());
        findGuide.setPhoneNumber(guideUpdateDto.getPhoneNumber());
        findGuide.setBiography(guideUpdateDto.getBiography());
        findGuide.setPhotoUrl(guideUpdateDto.getPhotoUrl());
        findGuide.setInstagram(guideUpdateDto.getInstagram());
        findGuide.setFacebook(guideUpdateDto.getFacebook());
        findGuide.setTwitter(guideUpdateDto.getTwitter());
        findGuide.setLinkedin(guideUpdateDto.getLinkedin());
        guideRepository.save(findGuide);

    }

}
