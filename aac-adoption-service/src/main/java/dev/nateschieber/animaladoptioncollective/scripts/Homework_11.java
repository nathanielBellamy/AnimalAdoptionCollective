package dev.nateschieber.animaladoptioncollective.scripts;

import dev.nateschieber.animaladoptioncollective.data.jdbcRepositories.JdbcPetRepository;

public class Homework_11 {

  public static void main(String[] args) {
    JdbcPetRepository repo = new JdbcPetRepository();

    repo.save(null);
  }

}
