package modele;

import java.time.LocalDate;

public class Location {

    private final String idBienImmobilier;
    private final String idLocataire;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double loyer;

    public Location(String idBienImmobilier, String idLocataire, LocalDate dateDebut, LocalDate dateFin, double loyer) {
        this.idBienImmobilier = idBienImmobilier;
        this.idLocataire = idLocataire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loyer = loyer;
    }

    // Getters and Setters
    public String getIdBienImmobilier() {
        return idBienImmobilier;
    }

    public String getIdLocataire() {
        return idLocataire;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }

}
