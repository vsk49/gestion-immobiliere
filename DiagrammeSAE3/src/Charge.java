import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f108f2ae-0194-4755-a8af-acd3e3aa1d29")
public abstract class Charge {
    @objid ("5e22bf1d-067c-4e9c-9bb5-1a6dc4aeb637")
    private String recuperable;

    @objid ("d62b9f49-4e69-41d8-bbd9-1d9d19c7b4aa")
    private String dateDebut;

    @objid ("399ebd65-9475-48d2-967d-ba47f729eb47")
    private String dateFin;

    @objid ("334db69f-c76a-45fc-af07-4f13121c4a04")
    public Charge() {
    }

    @objid ("2c52ec15-c235-437a-acaa-cd15c4a27c45")
    public abstract double montantTotalDeCharge();

}
