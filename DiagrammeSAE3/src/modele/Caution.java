package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3889119b-ddb1-49c6-8d2b-c1e806c252be")
public class Caution {
    @objid ("83ec0fd7-1525-420e-969d-13263dafd5c7")
    private String nom;

    @objid ("d8f77a87-7a36-43b6-9125-f96cd450239f")
    private String prenom;

    @objid ("01ce9941-c0e0-42b6-831f-0e50dab6d0f5")
    private String dateNaissance;

    @objid ("27ea3084-230c-4bb1-8b61-e4bd349f1da2")
    private String nationalite;

    @objid ("511e178e-e365-48a1-9f0a-a766cf912dda")
    private String adresse;

    @objid ("7508ea60-8ef2-4cc1-8cb1-fe4968c61e14")
    private String codePostal;

    @objid ("74c22ec8-5f89-4508-9a8a-9a3faf0e8b51")
    private String ville;

    @objid ("3b769214-3c53-4de4-8b35-c9cc78dfafb5")
    private String profession;

    @objid ("4a8ccdf1-c1b9-4400-b604-dcc050b0b0dc")
    private String employeur;

    @objid ("124faf9e-db3a-4080-b853-70f31ad099bc")
    private double revenusMensuelsNets;

    @objid ("9e33da25-98e5-4456-8cbb-943e7e348b5d")
    private String typeContratTravail;

    @objid ("93d5dd98-f95f-4208-9e16-b9e7a2e1ac27")
    private String lienLocataire;

    @objid ("e3360e90-ef20-40dc-a609-69a340247003")
    private String dateSignature;

    @objid ("69db6043-36e8-4932-aeda-a0197cb4dc7d")
    private double montantCautionne;

    @objid ("c085001e-5a81-4c8f-9a22-1a3cf8371937")
    private int idCaution;

    @objid ("c95e423a-55f5-4ca4-b07a-672cb80cd8ee")
    public Caution() {
    }

    @objid ("a8fdfdac-68ca-41dc-a9d8-e1fb51dc1043")
    public int getIdCaution() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.idCaution;
    }

}
