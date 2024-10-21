import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c8bb2370-0f48-4e44-b3c5-d10d889b06f4")
public class Compteur {
    @objid ("285549ff-3013-4993-a71e-486fcbffa08c")
    private String Type;

    @objid ("835285e2-bc4b-4250-850f-b61aad469538")
    private String numero;

    @objid ("46e11fd2-0d4d-4906-924f-665a679266b1")
    private String indexActuel;

    @objid ("d8630052-bbc6-45fd-b4fb-6d7be2129922")
    private String dateReleveEntree;

    @objid ("ba28f210-ecd2-42ad-bbec-94e5e75ca257")
    private String indexAncien;

    @objid ("8d2d8836-b875-4df0-854b-079dff0f019a")
    public Compteur(final String numero) {
    }

    @objid ("465ba065-fa78-411a-92ee-4a4a42b28d86")
    public int getAncienIndex() {
        // TODO Auto-generated return
        return 0;
    }

}
