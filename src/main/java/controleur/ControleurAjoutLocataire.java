package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.JDBCLocataire;
import modele.Locataire;
import vue.IHMAjouterLocataire;
import vue.IHMGestionLocataires;

public class ControleurAjoutLocataire implements ActionListener {

    private final IHMAjouterLocataire vue;
    private final JDBCLocataire modele;

    public ControleurAjoutLocataire(IHMAjouterLocataire vue) {
        this.modele = new JDBCLocataire();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton action = (JButton) e.getSource();
        if (action.getActionCommand().equals("Valider")) {
            Locataire l = construireLocataireSelonLesChamps();
            this.modele.insert(l);
        }
        this.vue.dispose();
        IHMGestionLocataires vueGestion = new IHMGestionLocataires();
        vueGestion.setVisible(true);
    }

    private Locataire construireLocataireSelonLesChamps() {
        String idLocataire = this.vue.getTextFieldNom().getText().substring(0, 1).toUpperCase()
                + this.vue.getTextFieldPrenom().getText().substring(0, 3).toUpperCase();
        return new Locataire(idLocataire, this.vue.getTextFieldNom().getText(),
                this.vue.getTextFieldPrenom().getText(), this.vue.getDatePickerNaissance().getDate(),
                this.vue.getTextFieldEmail().getText(), this.vue.getTextFieldTelephone().getText());
    }

}
