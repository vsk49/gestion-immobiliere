package modele;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e56ffde2-b15c-41ba-801f-762c266e0821")
public class Bail {
    @objid ("4ccfe992-be9b-4148-ac79-85f79b0ee814")
    private String dateDebut;

    @objid ("981f6bce-1404-4cc9-8b23-535a8f007c66")
    private double depotDeGarantie;

    @objid ("3a87af8e-4796-4a88-88d4-7399d37363ae")
    private String duree;

    @objid ("e1801cd2-5fc1-4d71-a556-88fdfff87b29")
    private String dateSignature;

    @objid ("8a204454-eeeb-45e8-8426-8b1d4a884dea")
    private String dateFin;

    @objid ("0341d32d-d50f-4dbc-8605-38ff55e51fc0")
    private String indexAncienBail;

    @objid ("3ed5bc5b-e070-468d-b79b-a609c006ddfd")
    private List<Locataire> locataires = new ArrayList<Locataire> ();

    @objid ("b0c6927b-7d40-4bc4-896b-82e52fc62696")
    private BienImmobilier bien;

    @objid ("e72f2e10-d5dd-41e8-ae66-f3b964686435")
    public Bail() {
    }

    @objid ("ca04e42b-aad2-4075-a63a-defed26db06b")
    public int nbLocataires() {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("7a50e018-9200-48a1-b288-6a48071719ff")
    public boolean estFini() {
        // TODO Auto-generated return
        return false;
    }

}
