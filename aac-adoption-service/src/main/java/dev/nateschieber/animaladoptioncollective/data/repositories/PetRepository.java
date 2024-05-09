package dev.nateschieber.animaladoptioncollective.data.repositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPetDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long>, IPetDataAccessor{
}
