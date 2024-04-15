package dev.nateschieber.animaladoptioncollective;

import dev.nateschieber.animaladoptioncollective.enums.RepositoryLocation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AacAdoptionService {

  private static RepositoryLocation repositoryLocation = RepositoryLocation.DATABASE;

  static {
    // TODO:
    //   - read in from config file common across services
  }

  public static void main(String[] args) {
    SpringApplication.run(AacAdoptionService.class, args);
  }
}
