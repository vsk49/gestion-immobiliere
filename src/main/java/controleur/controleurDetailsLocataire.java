package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

import modele.Locataire;
import vue.IHMDetailsLocataire;

public class controleurDetailsLocataire implements ActionListener {

	private IHMDetailsLocataire vue;
	private Locataire locataire;
	
	public controleurDetailsLocataire (IHMDetailsLocataire vue, Locataire locataire) {
		this.vue = vue;
		this.locataire = locataire;
//		this.vue.getModifPrenom().setText(locataire.getPrenom());
//		vue.getModifNom().setText(locataire.getNom());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
//		String dateStr = locataire.getDateNaissance().format(formatter);
//		vue.getModifDateNaissance().setText(dateStr);
//		vue.getModifTelephone().setText(locataire.getTelephone());
//		vue.getModifEmail().setText(locataire.getEmail());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getText()) {
        case "Annuler" :
			break;
        case "Réinitialiser" :
			break;
        case "Valider" :
        }
	}

}
