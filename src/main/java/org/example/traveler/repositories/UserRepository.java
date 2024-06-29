package org.example.traveler.repositories;

import org.example.traveler.dtos.userDtos.UserDashboardListDto;
import org.example.traveler.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
