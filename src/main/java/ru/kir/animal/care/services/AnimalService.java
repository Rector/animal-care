package ru.kir.animal.care.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kir.animal.care.dtos.AnimalDto;
import ru.kir.animal.care.error_handling.CommonError;
import ru.kir.animal.care.error_handling.ResourceNotFoundException;
import ru.kir.animal.care.models.Animal;
import ru.kir.animal.care.repositories.AnimalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<AnimalDto> findAll() {
        return animalRepository.findAll()
                .stream()
                .map(AnimalDto::new)
                .collect(Collectors.toList());
    }

    public AnimalDto findAnimalById(Long id) {
        return new AnimalDto(animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Animal with ID: '%d' not found\n", id))));
    }

    public void addNewAnimal(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setType(animalDto.getType());
        animal.setName(animalDto.getName());
        animal.setGender(animalDto.getGender());
        animal.setAge(animalDto.getAge());
        animal.setCondition(animalDto.getCondition());
        animal.setDescription(animalDto.getDescription());

        animalRepository.save(animal);
    }

}
