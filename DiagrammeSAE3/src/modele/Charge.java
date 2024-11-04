import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f108f2ae-0194-4755-a8af-acd3e3aa1d29")
public abstract class Charge {
    @objid ("d62b9f49-4e69-41d8-bbd9-1d9d19c7b4aa")
    private String dateDebut;

    @objid ("399ebd65-9475-48d2-967d-ba47f729eb47")
    private String dateFin;

    @objid ("d3d5ce6a-9d19-4eea-a238-754b73ca0b0f")
    private int idCharge;

    @objid ("6faefe9d-c588-4d7a-9996-004677be2e61")
    private double montantEau;

    @objid ("75ee7792-cee5-4d98-97d6-c928d43d12d3")
    private double montantCoPropriete;

    @objid ("62b5ac9d-82b4-4cff-a953-3e7060fe033b")
    private double montantElectricite;

    @objid ("334db69f-c76a-45fc-af07-4f13121c4a04")
    public Charge() {
    }

    @objid ("2c52ec15-c235-437a-acaa-cd15c4a27c45")
    public abstract double montantTotalDeCharge();

    @objid ("c643a725-566c-43e1-94b0-43fa473bf9f8")
    public int getIdCharge() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.idCharge;
    }

    @objid ("12153b23-e90b-4f3b-a8f9-c72f0b1911e6")
    public double getMontantEau() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.montantEau;
    }

    @objid ("e5340549-aa81-42d1-b1d4-1a1609f5fb97")
    public void setMontantEau(final double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.montantEau = value;
    }

    @objid ("d60400ad-eade-4847-b75e-d16125789329")
    public double getMontantCoPropriete() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.montantCoPropriete;
    }

    @objid ("ca8c13a0-eda6-47e3-82b1-c3e37cad06b0")
    public void setMontantCoPropriete(final double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.montantCoPropriete = value;
    }

    @objid ("0c4175ae-f778-496c-a1fa-e74cd7488105")
    public double getMontantElectricite() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.montantElectricite;
    }

    @objid ("5d8d4955-c720-4dd7-8b7b-a8801aab4bf4")
    public void setMontantElectricite(final double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.montantElectricite = value;
    }

}
