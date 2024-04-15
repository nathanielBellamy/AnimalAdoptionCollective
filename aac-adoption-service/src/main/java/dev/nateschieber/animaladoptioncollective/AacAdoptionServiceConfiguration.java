//package dev.nateschieber.animaladoptioncollective;
//
//import dev.nateschieber.animaladoptioncollective.enums.RepositoryLocation;
//import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
//import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepositoryFactory;
//import dev.nateschieber.animaladoptioncollective.services.AdoptionService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AacAdoptionServiceConfiguration {
//  private static RepositoryLocation repositoryLocation = RepositoryLocation.DATABASE;
//
//  static {
//    // TODO:
//    //   - read in from config file common across services
//  }
//
//  @Bean
//  public AdoptionService adoptionService() {
//    AdoptionService service = new AdoptionService();
//    return service;
//  }
//
//  @Bean("adoptionRepo")
//  public AdoptionRepository adoptionRepository() {
//    return AdoptionRepositoryFactory.get(repositoryLocation);
//  }
//}
