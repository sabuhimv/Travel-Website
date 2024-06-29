package org.example.traveler.dtos.userDtos;

import lombok.Getter;
import lombok.Setter;
import org.example.traveler.models.Role;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDetailDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String address;

}
