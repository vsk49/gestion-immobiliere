import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("283a5d4f-e5e8-473b-8e87-d44f1f6e8d01")
public class Locataire {
    @objid ("7b7503f6-80fb-48e6-a33b-6fe4fd6885bf")
    private String nom;

    @objid ("f475720d-4e0d-4af7-bf18-873239d0823b")
    private String prenom;

    @objid ("9d30aa2c-b792-45d2-ab8f-7ea6aa6371ba")
    private String genre;

    @objid ("0134b4d0-9570-445a-97bf-8f9593160ad9")
    private String dateNaissance;

    @objid ("090b97f1-338c-456a-b7b0-515034f78a5d")
    private String lieuNaissance;

    @objid ("b3961ef6-579f-4767-8a44-0a6557288c6b")
    private String nationalite;

    @objid ("65d422f4-a6a8-43ce-a446-e65bdb006b90")
    private String profession;

    @objid ("bb84a03c-5fc6-47fc-a3fc-53071cc4448a")
    private String telephone;

    @objid ("209d7096-416d-41f1-abfb-c8d71d3461ae")
    private String email;

    @objid ("b555daf8-a640-4311-8daf-963870c6b288")
    private String dateEntree;

    @objid ("648ca964-cece-4098-83ed-0e8dab228d65")
    private String dateDepart;

    @objid ("e7c832c3-3de1-44ca-a437-f427b1462f62")
    private double quotite;

    @objid ("07baf541-0a32-4ec2-ac85-95eca2c23e62")
    private List<BienImmobilier> bien = new ArrayList<BienImmobilier> ();

    @objid ("4066ef67-822e-46f1-aee1-f12663977af0")
    private Caution caution;

    @objid ("39d620dd-f05a-4b1d-b167-9427eda1829a")
    private List<Charge> charges = new ArrayList<Charge> ();

    @objid ("4e563465-5ee3-4831-a6aa-2172d16947df")
    public double soldeDeToutCompte() {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("006184a5-44d1-43fd-a462-c3b71dcb02e1")
    public boolean estLocataireAncien() {
        // TODO Auto-generated return
        return false;
    }

    @objid ("432867f7-3ff2-49d5-b340-1fadf802da70")
    public double nbMoisOccupation() {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("c1a8dc06-78e3-4b82-9967-8245c643491b")
    public Locataire() {
    }

}
