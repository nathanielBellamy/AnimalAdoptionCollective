package dev.nateschieber.animaladoptioncollective;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AacAdoptionServiceApplication {

  private static RepositoryLocation repositoryLocation = RepositoryLocation.DATABASE;

  static {
    // TODO:
    //   - read in from config file common across services
  }

  public static void main(String[] args) {
    SpringApplication.run(AacAdoptionServiceApplication.class, args);
  }
}
