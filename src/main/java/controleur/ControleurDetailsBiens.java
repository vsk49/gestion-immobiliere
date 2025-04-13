package controleur;

import modele.BienImmobilier;
import modele.JDBCLocation;
import modele.Location;
import vue.IHMDetailsBien;
import vue.IHMGestionBiens;
import vue.IHMModificationBien;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControleurDetailsBiens implements ActionListener {

    private final IHMDetailsBien vue;
    private final JDBCLocation jdbcLocation;
    private final BienImmobilier bien;

    public ControleurDetailsBiens(IHMDetailsBien vue, BienImmobilier bien) {
        this.bien = bien;
        this.vue = vue;
        this.jdbcLocation = new JDBCLocation();
        afficherLocataires(bien.getIdBienImmobilier());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Modifier")) {
            IHMModificationBien modificationVue = new IHMModificationBien(bien);
            modificationVue.setVisible(true);
        } else {
            IHMGestionBiens gestionBiensVue = new IHMGestionBiens();
            gestionBiensVue.setVisible(true);
        }
        this.vue.dispose();
    }

    private void afficherLocataires(String idBienImmobilier) {
        List<Location> locations = jdbcLocation.getAllByBien(idBienImmobilier);
        String[] columnNames = {"ID Locataire", "Date Début", "Date Fin", "Loyer"};
        Object[][] data = new Object[locations.size()][columnNames.length];
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            data[i][0] = location.getIdLocataire();
            data[i][1] = location.getDateDebut();
            data[i][2] = location.getDateFin();
            data[i][3] = location.getLoyer();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        vue.getTableLocataires().setModel(tableModel);
    }

}