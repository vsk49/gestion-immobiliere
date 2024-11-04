package modele;
import java.util.ArrayList;
import java.util.List;

public class BienImmobilier {
    private String adresse;
    private String numeroFiscal;
    private String codePostal;
    private String ville;
    private double montantTaxesFoncieres;
    private String dateAnniversaire;
    public double ICCDateDebut;
    private List<Locataire> locataires = new ArrayList<Locataire> ();
    private List<Assurance> assurances = new ArrayList<Assurance> ();

    public BienImmobilier(String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres, String dateAnniversaire, double ICCDateDebut, List<Locataire> locataires, List<Assurance> assurances) {
        this.adresse = adresse;
        this.numeroFiscal = numeroFiscal;
        this.codePostal = codePostal;
        this.ville = ville;
        this.montantTaxesFoncieres = montantTaxesFoncieres;
        this.dateAnniversaire = dateAnniversaire;
        this.ICCDateDebut = ICCDateDebut,
        this.locataires = locataires;
        this.assurances = assurances;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public String getNumeroFiscal(){
        return this.numeroFiscal;
    }

    public String getCP(){
        return this.codePostal;
    }

    public String getVille(){
        return this.ville;
    }

    public double getMontantTaxes(){
        return this.montantTaxesFoncieres;
    }

    public Stringn getDateAnniv(){
        return this.dateAnniversaire;
    }

    public double getICCDateDebut(){
        return this.ICCDateDebut;
    }

    public List<Locataire> getLocataires(){
        return this.locataires;
    }

    public List<Assurance> getAssurances(){
        return this.assurances;
    }
}
