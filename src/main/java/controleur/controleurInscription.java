package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.IHMConnexion;
import vue.IHMInscription;

import modele.Proprietaire;

public class controleurInscription implements ActionListener {

	private IHMInscription vue;

	public controleurInscription(IHMInscription vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton actionCommand = (JButton) e.getSource();
		switch (actionCommand.getActionCommand()) {
		case "Valider":
			String identifiant = vue.getIdentifiant();
			String motDePasse = vue.getMotDePasse();

			if (identifiant.isEmpty() || motDePasse.isEmpty()) {
				vue.afficherMessageErreur("Les champs identifiant et mot de passe ne doivent pas être vides.");
				return;
			}

			if (ajouterProprietaire(identifiant, motDePasse)) {
				vue.afficherMessageSucces("Inscription réussie !");
				IHMConnexion vueConnexion = new IHMConnexion();
				vueConnexion.setVisible(true);
				vue.dispose(); // Fermer la fenêtre après succès
			} else {
				vue.afficherMessageErreur(
						"Échec de l'inscription. L'utilisateur existe déjà ou une erreur est survenue.");
			}
			break;
		case "Annuler":
			IHMConnexion vueConnexion = new IHMConnexion();
			vueConnexion.setVisible(true);
			vue.dispose(); // Fermer la fenêtre après succès
			break;
		}
	}

	private boolean ajouterProprietaire(String idProprietaire, String motDePasse) {
		Proprietaire p = new Proprietaire(idProprietaire, motDePasse);
		return p.enregistrerProprietaire();
	}

}