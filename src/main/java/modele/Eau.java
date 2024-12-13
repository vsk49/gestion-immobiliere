package modele;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.MONTHS;

public class Eau extends Charge {

    public static double TTC_UNITAIRE_PARTIE_FIXE = 0.92;
    public static final double TTC_UNITAIRE_PARTIE_VARIABLE = 2.86;

    private final Compteur compteur;

    public Eau(int idCharge, LocalDate dateDebut, LocalDate dateFin, Compteur compteur) {
        super(idCharge, dateDebut, dateFin);
        this.compteur = compteur;
    }

    @Override
    public double getMontantCharge() {
        return TTC_UNITAIRE_PARTIE_FIXE * (MONTHS.between(this.getDateDebut(), this.getDateFin()))
                + this.compteur.getConsommation() * TTC_UNITAIRE_PARTIE_VARIABLE;
    }

}