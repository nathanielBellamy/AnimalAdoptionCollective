package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}
