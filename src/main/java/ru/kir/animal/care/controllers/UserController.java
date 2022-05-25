package ru.kir.animal.care.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kir.animal.care.dtos.UserRegisterDto;
import ru.kir.animal.care.models.User;
import ru.kir.animal.care.services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public UserRegisterDto registerNewUser(@RequestBody UserRegisterDto userRegisterDto){
        userRegisterDto.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userService.createNewUserWithRole(userRegisterDto);

        User user = userService.findByUsername(userRegisterDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not registered", userRegisterDto.getUsername())));
        return new UserRegisterDto(userRegisterDto.getUsername(), userRegisterDto.getPassword(), userRegisterDto.getEmail());
    }

}