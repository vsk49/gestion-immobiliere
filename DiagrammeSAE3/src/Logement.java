import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c3ad507d-61d1-40e1-82d8-f76ee6ba573c")
public class Logement extends BienLouable {
    @objid ("84ebcabd-eb07-4abe-a9dc-98bb6579e0c8")
    private Garage garage;

    @objid ("b38e75de-8a73-43e9-a9d4-b85bf5121df1")
    public boolean estEnColocation() {
        // TODO Auto-generated return
        return false;
    }

    @objid ("f81c789f-dc36-457e-abf7-c92facdf9ced")
    public Logement() {
    }

    @objid ("e27e91ac-cd4c-423c-92af-995a2c84a3a9")
    public String getDateDepartLocataire(final String id) {
        // TODO Auto-generated return
        return null;
    }

    @objid ("ac1679b6-7692-409a-a343-9186e814f209")
    public double getQuotiteLocataire(final String id) {
        // TODO Auto-generated return
        return 0;
    }

}
