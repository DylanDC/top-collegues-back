package dev.top.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Collegue;

public interface ColleguesRepo extends JpaRepository<Collegue, Integer> {
	public Collegue findByName(String name);

}
