package modele;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;

public class Electricite extends Charge {

    private double abonnementMensuel;

    public Electricite(int idCharge, LocalDate dateDebut, LocalDate dateFin, double abonnementMensuel) {
        super(idCharge, dateDebut, dateFin);
        this.abonnementMensuel = abonnementMensuel;
    }

    public double getAbonnementMensuel() {
        return this.abonnementMensuel;
    }

    @Override
    public double getMontantCharge() {
        return this.abonnementMensuel * (MONTHS.between(this.getDateDebut(), this.getDateFin()));
    }

}
