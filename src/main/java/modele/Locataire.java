package modele;

import java.time.LocalDate;
import java.util.Objects;

public class Locataire {

	private final String idLocataire;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String email;
	private String telephone;

	public Locataire(String idLocataire, String nom, String prenom, LocalDate dateNaissance, String email, String telephone) {
		this.idLocataire = idLocataire;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.telephone = telephone;
	}

	// getters
	public String getIdLocataire() {
		return this.idLocataire;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public String getEmail() {
		return this.email;
	}

	// setters
	public void setNom(String nom){
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(LocalDate date){
		this.dateNaissance = date;
	}

	public void setTelephone(String tel){
		this.telephone = tel;
	}

	public void setEmail(String email){
		this.email = email;
	}

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", email=" + email + ", telephone=" + telephone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLocataire, nom, prenom, dateNaissance, telephone, email);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || this.getClass() != other.getClass())
			return false;
		Locataire autre = (Locataire) other;
		return idLocataire.equals(autre.idLocataire) && nom.equals(autre.nom)
				&& prenom.equals(autre.prenom) && dateNaissance.equals(autre.dateNaissance)
				&& telephone.equals(autre.telephone) && email.equals(autre.email);
	}

}