package modele;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.MONTHS;

public class Eau extends Charge {

    private static final double ABONNEMENT_MENSUEL = 14.06;
    private static final double ABONNEMENT_EAU_COMPTEUR = 5.51;
    private static final double TTC_UNITAIRE_EAU_POTABLE = 1.01;
    private static final double TTC_UNITAIRE_SOUTIEN_ETAYAGE = 0.01;
    private static final double TTC_UNITAIRE_PRESERVATION_EAU = 0.08;
    private static final double TTC_UNITAIRE_EAU_USES = 1.1;
    private static final double TTC_UNITAIRE_ORGANISME_PUBLIC = 0.63;

    private Compteur compteur;

    public Eau(int idCharge, LocalDate dateDebut, LocalDate dateFin, Compteur compteur) {
        super(idCharge, dateDebut, dateFin);
        this.compteur = compteur;
    }

    @Override
    public double getMontantCharge() {
        return ABONNEMENT_MENSUEL * (MONTHS.between(this.getDateDebut(), this.getDateFin())) + ABONNEMENT_EAU_COMPTEUR
                + this.compteur.getConsommation() * (TTC_UNITAIRE_EAU_POTABLE + TTC_UNITAIRE_SOUTIEN_ETAYAGE
                        + TTC_UNITAIRE_PRESERVATION_EAU + TTC_UNITAIRE_EAU_USES + TTC_UNITAIRE_ORGANISME_PUBLIC);
    }

}