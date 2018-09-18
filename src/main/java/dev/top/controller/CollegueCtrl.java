package dev.top.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.repos.ColleguesRepo;

@RestController
@CrossOrigin
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
	public Collegue majCollegue(@RequestBody String action, @PathVariable String nom) {
		Collegue collegueUpdate = new Collegue();
		if (action != null && StringUtils.isNotEmpty(action) && action.contains("AIMER")) {
			if (collegue.findByName(nom).getScore() <= 990) {
				Integer aimer = collegue.findByName(nom).getScore() + 10;
				collegueUpdate = collegue.findByName(nom);
				collegueUpdate.setScore(aimer);
			} else if (collegue.findByName(nom).getScore() == 995) {
				Integer aimer = collegue.findByName(nom).getScore() + 5;
				collegueUpdate = collegue.findByName(nom);
				collegueUpdate.setScore(aimer);

			}
		}

		if (action != null && StringUtils.isNotEmpty(action) && action.contains("DETESTER")) {
			if (collegue.findByName(nom).getScore() > -1000) {
				Integer detester = collegue.findByName(nom).getScore() - 5;
				collegueUpdate = collegue.findByName(nom);
				collegueUpdate.setScore(detester);
			}

		}
		collegue.save(collegueUpdate);
		return collegue.findByName(nom);
	}

}
