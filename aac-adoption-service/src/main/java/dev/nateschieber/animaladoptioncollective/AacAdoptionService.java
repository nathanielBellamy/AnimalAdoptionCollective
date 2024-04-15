package dev.nateschieber.animaladoptioncollective;

import dev.nateschieber.animaladoptioncollective.enums.RepositoryLocation;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepositoryFactory;
import dev.nateschieber.animaladoptioncollective.services.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AacAdoptionService {

  private static RepositoryLocation repositoryLocation = RepositoryLocation.DATABASE;

  static {
    // TODO:
    //   - read in from config file common across services
  }

  @Bean("adoptionRepo")
  public AdoptionRepository adoptionRepo() {
    return AdoptionRepositoryFactory.get(repositoryLocation);
  }

  public static void main(String[] args) {
//    ApplicationContext context = new AnnotationConfigApplicationContext(AacAdoptionServiceConfiguration.class);
//    AdoptionService service = context.getBean("adoptionService", AdoptionService.class);
//    service.printRepo();
//
//    AdoptionRepository repo1 = context.getBean("adoptionRepository", AdoptionRepository.class);
//    AdoptionRepository repo2 = context.getBean("adoptionRepository", AdoptionRepository.class);
//
//    System.out.println(repo1);
//    System.out.println(repo2);

    SpringApplication.run(AacAdoptionService.class, args);
  }
}
