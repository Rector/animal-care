package ru.kir.animal.care.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterDto {
    private String username;
    private String password;
    private String email;
}
