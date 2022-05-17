package ru.kir.animal.care.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kir.animal.care.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
