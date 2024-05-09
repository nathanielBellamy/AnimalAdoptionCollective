package dev.nateschieber.animaladoptioncollective.data.repositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IAdoptionDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, Long>, IAdoptionDataAccessor { }
