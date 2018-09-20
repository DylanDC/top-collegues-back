package dev.top;

import org.springframework.core.convert.converter.Converter;

import dev.top.controller.views.CollegueView;
import dev.top.entities.Collegue;

public interface Converters {

	Converter<Collegue, CollegueView> COLLEGUE_TO_COLLEGUE_VIEW = source -> {
		CollegueView collegueWeb = new CollegueView();

		collegueWeb.setName(source.getName());
		collegueWeb.setScore(source.getScore());
		collegueWeb.setUrl(source.getUrl());
		collegueWeb.setNom(source.getNom());
		collegueWeb.setPrenom(source.getPrenom());
		collegueWeb.setAdresse(source.getAdresse());
		collegueWeb.setDateNaissance(source.getDateNaissance());
		collegueWeb.setMatricule(source.getMatricule());

		return collegueWeb;
	};

	Converter<CollegueView, Collegue> COLLEGUE_VIEW_TO_COLLEGUE = source -> {
		Collegue collRepo = new Collegue();

		collRepo.setName(source.getName());
		collRepo.setScore(source.getScore());
		collRepo.setUrl(source.getUrl());
		collRepo.setNom(source.getNom());
		collRepo.setPrenom(source.getPrenom());
		collRepo.setAdresse(source.getAdresse());
		collRepo.setDateNaissance(source.getDateNaissance());
		collRepo.setMatricule(source.getMatricule());

		return collRepo;
	};

}
