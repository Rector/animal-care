package ru.kir.animal.care.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kir.animal.care.dtos.AnimalDto;
import ru.kir.animal.care.models.Animal;
import ru.kir.animal.care.services.AnimalService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/animals")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping
    public List<AnimalDto> getAllAnimals(){
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public AnimalDto getAnimalById(@PathVariable Long id){
        Animal animal =  animalService.findAnimalById(id).orElseThrow(() -> new NoSuchElementException("Animal for ID: " + id + " not found"));
        return new AnimalDto(animal);
    }
}
