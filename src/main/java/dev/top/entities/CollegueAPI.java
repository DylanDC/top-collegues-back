package dev.top.entities;

public class CollegueAPI {
	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	private String sexe;
	private String adresse;
	private String password;
	private String photo;
	private String[] subalternes;

	public CollegueAPI(String matricule, String nom, String prenom, String email, String dateNaissance, String sexe,
			String adresse, String password, String photo, String[] subalternes) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.password = password;
		this.photo = photo;
		this.subalternes = subalternes;
	}

	public CollegueAPI() {
		super();
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String[] getSubalternes() {
		return subalternes;
	}

	public void setSubalternes(String[] subalternes) {
		this.subalternes = subalternes;
	}

}
