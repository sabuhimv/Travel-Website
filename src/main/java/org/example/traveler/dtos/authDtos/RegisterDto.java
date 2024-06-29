package org.example.traveler.dtos.authDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String email;
    private String password;
    private String passwordRepeat;

    private String firstName;
    private String lastName;
    private String username;
    private String phone_number;
    private String address;
}
