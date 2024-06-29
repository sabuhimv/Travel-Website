package org.example.traveler.services;

import org.example.traveler.dtos.guideDtos.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface GuideService {

    void addGuide(GuideCreateDto guideCreateDto);
    List<GuideDto> getAllActiveGuides();
    List<GuideDto> getAllGuides();
    void removeGuide(Long id);
    List<GuidePersonalDto> getTeamGuides();
    GuideDetailDto guideDetail(Long id);
    GuideUpdateDto findUpdateGuide(Long id);
    void updateGuide (GuideUpdateDto guideUpdateDto);
}
