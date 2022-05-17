package ru.kir.animal.care.dtos;

import lombok.Data;
import ru.kir.animal.care.models.Animal;

@Data
public class AnimalDto {
    private Long id;
    private String type;
    private String name;
    private String gender;
    private int age;
    private String condition;
    private String description;

    public AnimalDto(Animal animal) {
        this.id = animal.getId();
        this.type = animal.getType();
        this.name = animal.getName();
        this.gender = animal.getGender();
        this.age = animal.getAge();
        this.condition = animal.getCondition();
        this.description = animal.getDescription();
    }
}
