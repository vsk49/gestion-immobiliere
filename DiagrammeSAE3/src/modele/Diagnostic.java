package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a3fa38e1-c6a2-40a4-af1b-cf741807175d")
public class Diagnostic {
    @objid ("bc85d5a5-2394-4237-bfae-a7a6d3195bb1")
    private String dateRealisation;

    @objid ("0129e1a3-dcfe-4b70-b45e-a28a3768c739")
    private String reference;

    @objid ("d7fb9e66-46e0-48bc-a021-e2ebf87e6d22")
    private String type;

    @objid ("a4875c66-3380-4ffe-b3dd-e0d947b4721f")
    private String dateExpiration;

    @objid ("8394580e-c73a-44fa-99e6-73da6c05ee26")
    private String classification;

    @objid ("f45d9a90-151e-45e9-997e-bd1a41b8ac8e")
    private String operateur;

    @objid ("c8d714b1-9c6e-44aa-9024-3eeca5addae0")
    private String numeroRapport;

    @objid ("b63ba621-bd14-4576-a00b-1febb031ee00")
    private BienImmobilier bien;

    @objid ("0426dd66-1621-48a3-bf85-b31dbb94eefb")
    public Diagnostic() {
    }

}
