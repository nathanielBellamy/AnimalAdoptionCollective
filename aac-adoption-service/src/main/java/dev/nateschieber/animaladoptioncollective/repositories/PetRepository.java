package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.IPetDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long>, IPetDataAccessor{
}
