package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, UUID> {}
