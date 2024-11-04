package modele;
import java.util.ArrayList;
import java.util.List;

public class Batiment extends BienImmobilier {
    private List<BienLouable> biensLouables = new ArrayList<BienLouable> ();

    public Batiment(List<BienLouable> biensLouables) {
        this.biensLouables = biensLouables;
    }
    
    public void addBien (BienLouable bien){
        this.biensLouables.add(bien);
    }

    public List<BienLouable> getBiens(){
        return this.biensLouables;
    }

}
