package dev.top.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.Converters;
import dev.top.controller.views.AvisView;
import dev.top.controller.views.CollegueView;
import dev.top.controller.views.FormView;
import dev.top.entities.Collegue;
import dev.top.services.CollegueService;

@RestController // si utiliser le @responsebody(traduit en json) est inutile
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueCtrl {
	private CollegueService collegueServ;

	public CollegueCtrl(CollegueService collegueServ) {
		super();
		this.collegueServ = collegueServ;
	}

	// *************************************GET***********************************************
	@GetMapping
	public ResponseEntity<List<CollegueView>> findAll() {
		return ResponseEntity.ok(this.collegueServ.listerCollegues().stream()
				.map(col -> Converters.COLLEGUE_TO_COLLEGUE_VIEW.convert(col)).collect(Collectors.toList()));

	}

	@GetMapping("/{nom}")
	public ResponseEntity<CollegueView> findByName(@PathVariable String nom) {
		return ResponseEntity.ok(Converters.COLLEGUE_TO_COLLEGUE_VIEW.convert(this.collegueServ.findCollegue(nom)));
	}

	// *************************************PATCH***********************************************
	@PatchMapping("/{nom}")
	public ResponseEntity<CollegueView> patch(@PathVariable String nom, @RequestBody AvisView avis) {

		Collegue collegueModifie = this.collegueServ.majCollegue(nom, avis.getAction());

		return ResponseEntity.ok(Converters.COLLEGUE_TO_COLLEGUE_VIEW.convert(collegueModifie));
	}

	// *************************************POST***********************************************
	@PostMapping("/nouveau")
	public ResponseEntity<String> post(@RequestBody FormView form) {
		Collegue newCol = this.collegueServ.findByMatricule(form.getMatricule());
		newCol.setName(form.getPseudo());
		return ResponseEntity.ok(this.collegueServ.saveCollegue(newCol));
	}
}
