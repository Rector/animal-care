package ru.kir.animal.care.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kir.animal.care.dtos.AnimalDto;
import ru.kir.animal.care.services.AnimalService;

import java.util.List;

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
        return animalService.findAnimalById(id);
    }

    @PostMapping
    public void addNewAnimal(@RequestBody AnimalDto animalDto){
        animalService.addNewAnimal(animalDto);
//        return animalDto;
    }
}
