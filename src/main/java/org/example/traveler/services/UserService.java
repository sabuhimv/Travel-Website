package org.example.traveler.services;

import org.example.traveler.dtos.authDtos.RegisterDto;
import org.example.traveler.dtos.guideDtos.GuideDetailDto;
import org.example.traveler.dtos.userDtos.*;

import java.util.List;

public interface UserService {
    boolean register(RegisterDto registerDto);
    boolean confirmEmail(String email,String token);
    List<UserDashboardListDto> getDashboardUsers();
    UserDto getUserById(Long id);
    void addRole(UserAddRoleDto userAddRoleDto);
    UserDetailDto userDetail(Long id);
    UserDetailDto getByEmail(String email);
    UserUpdateDto findUpdateUser(Long id);
    void updateUser(UserUpdateDto userUpdateDto);
}
