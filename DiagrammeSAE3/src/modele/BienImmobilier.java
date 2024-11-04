package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7f7ea608-08d1-460b-9e59-06d206f2d4a4")
public class BienImmobilier {
    @objid ("550a8389-0c52-4d57-ad54-35320a76beb5")
    private String adresse;

    @objid ("6c884ef6-3d8f-45c2-9dc9-9359ac0bb3f9")
    private String numeroFiscal;

    @objid ("447bd17a-8438-477b-9eb7-607abe997608")
    private String codePostal;

    @objid ("fd2000c4-277c-4ad1-9e98-78424942bd71")
    private String ville;

    @objid ("e59d8bda-4003-4b64-846f-e6bc6e8727c5")
    private double montantTaxesFoncieres;

    @objid ("add782a0-339e-42c0-8775-2684055a2947")
    private String dateAnniversaire;

    @objid ("3dfd47c5-b223-43ec-b4bf-6872f9909945")
    public double ICCDateDebut;

    @objid ("46e911a8-3f0a-4ac0-b256-2ed5f1ee854b")
    private int idBienImmobilier;

    @objid ("d59ef5c8-f940-45c3-9c35-d83b12d6c232")
    private List<Locataire> locataires = new ArrayList<Locataire> ();

    @objid ("9193ca09-b18b-43c6-a957-bfc569e991c0")
    private List<Assurance> assurances = new ArrayList<Assurance> ();

    @objid ("c9651a20-2e69-442a-994a-e078da58f0a4")
    public BienImmobilier() {
    }

    @objid ("4674b49c-a2e0-4e26-89bc-3ef502f40eb2")
    public int getIdBienImmobilier() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.idBienImmobilier;
    }

}
