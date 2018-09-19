package dev.top.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.top.entities.Avis;
import dev.top.entities.Collegue;
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
}
