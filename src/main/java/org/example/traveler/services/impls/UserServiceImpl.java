package org.example.traveler.services.impls;

import org.example.traveler.dtos.authDtos.RegisterDto;
import org.example.traveler.dtos.guideDtos.GuideDetailDto;
import org.example.traveler.dtos.userDtos.*;
import org.example.traveler.models.Guide;
import org.example.traveler.models.Role;
import org.example.traveler.models.UserEntity;
import org.example.traveler.repositories.RoleRepository;
import org.example.traveler.repositories.UserRepository;
import org.example.traveler.services.EmailService;
import org.example.traveler.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;

    @Override
    public boolean register(RegisterDto registerDto) {
        UserEntity user = userRepository.findByEmail(registerDto.getEmail());

        if (user != null){
            return false;
        }

        UserEntity newUser = modelMapper.map(registerDto, UserEntity.class);
        newUser.setEmailConfirmed(false);

        String hashedPassword = bCryptPasswordEncoder.encode(registerDto.getPassword());
        newUser.setPassword(hashedPassword);

        String token = bCryptPasswordEncoder.encode(registerDto.getPassword());
        newUser.setConfirmationToken(token);

        userRepository.saveAndFlush(newUser);

        emailService.sendConfirmationToken(registerDto.getEmail(),token);

        return true;
    }

    @Override
    public boolean confirmEmail(String email, String token) {
        UserEntity findUser = userRepository.findByEmail(email);
        if (findUser.getConfirmationToken().equals(token) && findUser!=null){
            findUser.setEmailConfirmed(true);
            userRepository.saveAndFlush(findUser);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDashboardListDto> getDashboardUsers() {
        List<UserEntity> findUsers = userRepository.findAll();
        List<UserDashboardListDto> users = findUsers.stream().map(user -> modelMapper.map(user,UserDashboardListDto.class)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity findUser = userRepository.findById(id).orElseThrow();
        UserDto user = modelMapper.map(findUser,UserDto.class);
        return user;
    }

    @Override
    public void addRole(UserAddRoleDto userAddRoleDto) {
        UserEntity findUser = userRepository.findByEmail(userAddRoleDto.getEmail());
        List<Role> roles = roleRepository.findAll().stream().filter(x->x.getId() == userAddRoleDto.getRoleId()).collect(Collectors.toList());
        findUser.setRoles(roles);
        userRepository.save(findUser);
    }

    @Override
    public UserDetailDto userDetail(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        return modelMapper.map(user, UserDetailDto.class);
    }

    @Override
    public UserDetailDto getByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserDetailDto.class);
    }

    @Override
    public UserUpdateDto findUpdateUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        UserUpdateDto userUpdateDto = modelMapper.map(user,UserUpdateDto.class);
        return userUpdateDto;
    }

    @Override
    public void updateUser(UserUpdateDto userUpdateDto) {
        UserEntity findUser = userRepository.findById(userUpdateDto.getId()).orElseThrow();
        findUser.setId(userUpdateDto.getId());
        findUser.setEmail(userUpdateDto.getEmail());
        findUser.setFirstName(userUpdateDto.getFirstName());
        findUser.setLastName(userUpdateDto.getLastName());
        findUser.setUsername(userUpdateDto.getUsername());
        findUser.setPhoneNumber(userUpdateDto.getPhoneNumber());
        findUser.setAddress(userUpdateDto.getAddress());
        userRepository.saveAndFlush(findUser);
    }
}
