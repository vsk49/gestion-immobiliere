package modele;

import java.time.LocalDate;

public class Assurance {
    
	private int idAssurance;
    private TypeAssurance type;
    private double prime;
    private LocalDate dateDebutAssurance;
    private String nomAssureur;
    private double quotiteJurisprudence;
    private double protectionJuridique;

    public Assurance() {
    }

    public int getIdAssurance() {
        return this.idAssurance;
    }

}
