package dev.top.controller.views;

public class FormView {
	private String matricule;
	private String urlImage;
	private String pseudo;

	public FormView() {
		super();
	}

	public FormView(String matricule, String url, String pseudo) {
		super();
		this.matricule = matricule;
		urlImage = url;
		this.pseudo = pseudo;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getUrl() {
		return urlImage;
	}

	public void setUrl(String url) {
		urlImage = url;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

}
