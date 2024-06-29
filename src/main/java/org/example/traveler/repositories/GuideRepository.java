package org.example.traveler.repositories;

import org.example.traveler.models.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide,Long> {
//    List<Guide> findByAvailableTrue();
}
