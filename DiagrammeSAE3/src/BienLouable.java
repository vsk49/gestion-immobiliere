import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b58b22e7-78f7-4397-a6c3-6aaef89dc8dc")
public class BienLouable extends BienImmobilier {
    @objid ("e38abc5b-0eae-4ef7-9b33-414bd8aafb5c")
    private double surface;

    @objid ("93bbb279-9647-4cfc-9438-a013c5efc808")
    private int nbPieces;

    @objid ("beea9c07-e157-40b4-a766-fabfddb5b453")
    private List<FactureTravail> travaux = new ArrayList<FactureTravail> ();

    @objid ("5061d31b-b3a4-4376-9639-29893836645b")
    private Compteur compteur;

    @objid ("8f4d0554-9e69-4293-9506-b5bb7b801db1")
    public BienLouable() {
    }

    @objid ("bda9c662-1ad2-4aac-8362-88590e413284")
    public void changerCompteur(final Compteur nvCompteur) {
    }

}
