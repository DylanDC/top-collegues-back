package dev.top.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Collegue;

public interface ColleguesRepo extends JpaRepository<Collegue, Integer> {

	Optional<Collegue> findByName(String name);

	boolean existsByMatricule(String matricule);

}
