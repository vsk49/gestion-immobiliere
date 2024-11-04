package modele;
import java.util.ArrayList;
import java.util.List;

public class Bail {
    private String dateDebut;
    private double depotDeGarantie;
    private String duree;
    private String dateSignature;
    private String dateFin;
    private String indexAncienBail;
    private List<Locataire> locataires = new ArrayList<Locataire> ();
    private BienImmobilier bien;

    public Bail(String dateDeb, double depot, String duree, String dateS, String dateF, String index, BienImmobilier bien) {
        this.dateDebut = dateDeb;
        this.depotDeGarantie = depot;
        this.duree = duree;
        this.dateSignature = dateS;
        this.dateFin = dateF;
        this.indexAncienBail = index;
        this.bien = bien;
    }

    public void addLocataires (Locataire loc){
        this.locataires.add(loc);
    }

    public String getDateDebut(){
        return this.dateDebut;
    }

    public double getDepot(){
        return this.depotDeGarantie;
    }

    public String getDuree(){
        return this.duree;
    }

    public String getDateSignature() {
        return this.dateSignature;
    }

    public String getDateFin(){
        return this.dateFin;
    }

    public String getIndex(){
        return this.indexAncienBail;
    }

    public List<Locataire> getLocataires (){
        return this.locataires;
    }

    public BienImmobilier getBien(){
        return this.bien;
    }

    public int nbLocataires() {
        return this.locataires.length();
    }

    public boolean estFini() {
        // TODO Auto-generated return
        return false;
    }

}
