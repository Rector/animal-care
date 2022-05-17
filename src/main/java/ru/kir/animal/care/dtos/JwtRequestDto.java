package ru.kir.animal.care.dtos;

import lombok.Data;

@Data
public class JwtRequestDto {
    private String username;
    private String password;
}
