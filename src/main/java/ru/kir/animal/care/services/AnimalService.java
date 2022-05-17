package ru.kir.animal.care.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kir.animal.care.dtos.AnimalDto;
import ru.kir.animal.care.models.Animal;
import ru.kir.animal.care.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<AnimalDto> findAll(){
//        List<Animal> animals = animalRepository.findAll();
//        List<AnimalDto> animalDtos = new ArrayList<>();
//        for(int i = 0; i < animals.size(); i++){
//
//        }
        return animalRepository.findAll().stream().map(AnimalDto::new).collect(Collectors.toList());
    }

    public Optional<Animal> findAnimalById(Long id){
        return animalRepository.findById(id);
    }
}
