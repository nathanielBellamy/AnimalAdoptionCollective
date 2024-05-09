package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.daoInterfaces.IAdoptionDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, Long>, IAdoptionDataAccessor { }
