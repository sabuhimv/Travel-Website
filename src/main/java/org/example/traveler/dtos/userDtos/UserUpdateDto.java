package org.example.traveler.dtos.userDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String address;
}
