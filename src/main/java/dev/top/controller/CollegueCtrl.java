package dev.top.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Collegue majCollegue(@RequestBody Collegue action, @PathVariable String nom) {

		if (action != null && action.equals("AIMER")) {
			Integer aimer = collegue.findByName(nom).getScore() + 10;
			collegue.findByName(nom).setScore(aimer);
		}
		if (action != null && action.equals("DETESTER")) {
			Integer detester = collegue.findByName(nom).getScore() - 5;
			collegue.findByName(nom).setScore(detester);
		}
		return collegue.findByName(nom);
	}

}
