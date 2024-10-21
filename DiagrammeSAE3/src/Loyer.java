import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c2ee39a9-ae24-4e96-92b9-84f600fdbe41")
public class Loyer {
    @objid ("7bbf3f28-414e-494a-9cc7-7fce980e04b8")
    private String dateLoyer;

    @objid ("292253a2-2901-4ecb-943f-cf53166f0d62")
    private double montantLoyer;

    @objid ("c8c88539-311c-4d89-bbb9-101b80c32252")
    private double provisionPourCharge;

    @objid ("fca98ac9-da29-4c40-984c-6af403047010")
    private Logement logement;

    @objid ("47ee677f-0aec-441a-81a9-365dd44fe5e9")
    private Locataire locataire;

    @objid ("11ea9f40-5dc0-484b-9795-985bdec4340d")
    public Loyer() {
    }

}
