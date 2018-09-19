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

		return collegueWeb;
	};

	Converter<CollegueView, Collegue> COLLEGUE_VIEW_TO_COLLEGUE = source -> {
		Collegue collRepo = new Collegue();

		collRepo.setName(source.getName());
		collRepo.setScore(source.getScore());
		collRepo.setUrl(source.getUrl());

		return collRepo;
	};

}
