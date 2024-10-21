package modele;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("093cb4fb-88fe-47ff-b54e-965d0b42b772")
public class Batiment extends BienImmobilier {
    @objid ("dc27e42c-032d-41d3-81a2-fe3a9b552e9c")
    private List<BienLouable> biensLouables = new ArrayList<BienLouable> ();

    @objid ("a556e9eb-cb46-4f3f-abe6-592da6ab9f99")
    public Batiment() {
    }

}
