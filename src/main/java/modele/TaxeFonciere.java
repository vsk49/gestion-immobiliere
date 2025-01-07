package modele;

public record TaxeFonciere(int idTaxeFonciere, int annee, double montantBase, BienImmobilier bien) {

    private static final double TAUX_COMMUNE = 0.3535;
    private static final double TAUX_INTER_COMMUNALITE = 0.132;
    private static final double TAUX_TAXES_SPECIALES = 0.00415;
    private static final double TAUX_ORDURES_MENAGERES = 0.081;
    private static final double TAUX_GEMAPI = 0.00274;

    public double getMontantTotalCotisations() {
        return (TAUX_COMMUNE + TAUX_INTER_COMMUNALITE + TAUX_TAXES_SPECIALES + TAUX_ORDURES_MENAGERES + TAUX_GEMAPI)
                * this.montantBase;
    }

    public double getMontantOrduresMenageres() {
        return TAUX_ORDURES_MENAGERES * this.montantBase;
    }

    public double getMontantADeclarerIR() {
        return this.getMontantTotalCotisations() - this.getMontantOrduresMenageres();
    }

}
