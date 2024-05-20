package dev.nateschieber.animaladoptioncollective.data.jpaRepositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPetDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPetRepository extends JpaRepository<Pet, Long>, IPetDataAccessor{
}
