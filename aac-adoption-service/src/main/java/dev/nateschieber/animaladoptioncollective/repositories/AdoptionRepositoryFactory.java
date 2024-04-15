package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.enums.RepositoryLocation;

public class AdoptionRepositoryFactory {
  public static AdoptionRepository get(RepositoryLocation repositoryLocation) {
    return switch (repositoryLocation) {
      case RepositoryLocation.DATABASE -> new DatabaseRepository();
      case RepositoryLocation.MEMORY   -> new MemoryRepository();
    };
  }
}
