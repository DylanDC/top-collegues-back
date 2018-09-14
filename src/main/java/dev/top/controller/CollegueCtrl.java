package dev.top.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.repos.ColleguesRepo;

@RestController
@RequestMapping("/collegues")
public class CollegueCtrl {
	private ColleguesRepo collegue;

	public CollegueCtrl(ColleguesRepo collegue) {
		super();
		this.collegue = collegue;
	}

	@GetMapping
	public ResponseEntity<List<Collegue>> listerCollegue() {
		return ResponseEntity.ok(collegue.findAll());
	}

	@PatchMapping("/{nom}")
	public Collegue majCollegue(@PathVariable String nom, Integer score) {
		collegue.findByName(nom).setScore(score);

		return collegue.findByName(nom);
	}

}
