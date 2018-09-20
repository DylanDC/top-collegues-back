package dev.top.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueAPI;
import dev.top.exceptions.PseudoInvalideException;
import dev.top.exceptions.ServiceExceptions;
import dev.top.repos.ColleguesRepo;

@Service
public class CollegueService {
	private ColleguesRepo collRepo;

	public CollegueService(ColleguesRepo collRepo) {
		super();
		this.collRepo = collRepo;
	}

	public List<Collegue> listerCollegues() {
		return this.collRepo.findAll();
	}

	public Collegue majCollegue(String name, Avis avis) throws PseudoInvalideException, ServiceExceptions {
		return this.collRepo.findByName(name).map(collegueTrouve -> {

			if (Avis.AIMER.equals(avis)) {
				if (collegueTrouve.getScore() <= 990) {
					collegueTrouve.setScore(collegueTrouve.getScore() + 10);

				} else if (collegueTrouve.getScore() == 995) {
					collegueTrouve.setScore(collegueTrouve.getScore() + 5);
				}
			}

			if (Avis.DETESTER.equals(avis)) {
				if (collegueTrouve.getScore() > -1000) {
					collegueTrouve.setScore(collegueTrouve.getScore() - 5);
				}
			}

			this.collRepo.save(collegueTrouve);

			return collegueTrouve;
		}).orElseThrow(() -> new PseudoInvalideException());
	}

	public Collegue findCollegue(String name) throws PseudoInvalideException, ServiceExceptions {

		return this.collRepo.findByName(name).orElseThrow(() -> new PseudoInvalideException());
	}

	public Collegue findByMatricule(String mat) throws PseudoInvalideException, ServiceExceptions {
		RestTemplate rest = new RestTemplate();
		CollegueAPI[] collegueApi = rest.getForObject("http://collegues-api.cleverapps.io/collegues?matricule=" + mat,
				CollegueAPI[].class);
		Collegue collegue = new Collegue(0, null, collegueApi[0].getPhoto(), collegueApi[0].getMatricule(),
				collegueApi[0].getNom(), collegueApi[0].getPrenom(), collegueApi[0].getEmail(),
				collegueApi[0].getDateNaissance(), collegueApi[0].getSexe(), collegueApi[0].getAdresse());
		return collegue;
	}

	public String saveCollegue(Collegue collegue) {
		collRepo.save(collegue);
		return "ok";
	}

}
