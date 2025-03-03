package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import dao.JDBCLocataire;
import modele.Locataire;
import vue.IHMDetailsLocataire;
import vue.IHMGestionLocataires;
import vue.IHMModificationLocataire;

import javax.swing.*;

public class ControleurDetailsLocataire implements ActionListener {

	private final IHMDetailsLocataire vue;
	private final Locataire locataire;

    public ControleurDetailsLocataire (IHMDetailsLocataire vue, Locataire locataire) {
        JDBCLocataire modele = new JDBCLocataire();
		this.vue = vue;
		this.locataire = modele.getById(locataire.getIdLocataire()).orElseThrow();
		afficherInformationsLocataire(vue, locataire);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = ((JButton) e.getSource()).getText();
        switch (text) {
			case "Retour" :
				IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
				this.vue.dispose();
				vueGestionLocataires.setVisible(true);
				break;
			case "Modifier" :
				IHMModificationLocataire vueModificationLocataire = new IHMModificationLocataire(this.locataire);
				this.vue.dispose();
				vueModificationLocataire.setVisible(true);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + text);
        }
	}

	private void afficherInformationsLocataire(IHMDetailsLocataire vue, Locataire locataire) {
		vue.getModifPrenom().setText(locataire.getPrenom());
		vue.getModifNom().setText(locataire.getNom());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String dateStr = locataire.getDateNaissance().format(formatter);
		vue.getModifDateNaissance().setText(dateStr);
		vue.getModifTelephone().setText(locataire.getTelephone());
		vue.getModifEmail().setText(locataire.getEmail());
	}

}
