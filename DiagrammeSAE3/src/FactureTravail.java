import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("659e4e4d-821d-40bc-b530-3a92926649da")
public class FactureTravail {
    @objid ("de970ccd-b717-40b2-908e-0e99bef76a7f")
    private String entreprise;

    @objid ("b26044ac-af2a-4524-807f-12aedfa77dfa")
    private String numeroFacture;

    @objid ("f2abb3cd-2394-40c1-9f75-32f46a81a4b4")
    private String date;

    @objid ("87241ade-3dc4-41a5-a9e1-244ffb57c203")
    private String referenceDevis;

    @objid ("c6fe2ec7-2298-4697-ba2e-cd08e35c87af")
    private double montant;

    @objid ("1d21648a-d208-403f-a998-24283daf3d36")
    private String nature;

    @objid ("a80f3d52-c9a3-4d76-bb27-7a347abe9511")
    private double montantDevis;

    @objid ("691e6514-d76e-4063-b00a-67e10e133b7c")
    public FactureTravail() {
    }

}
