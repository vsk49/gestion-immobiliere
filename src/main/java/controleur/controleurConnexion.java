package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.Proprietaire;
import vue.IHMAccueil;
import vue.IHMConnexion;
import vue.IHMInscription;

public class controleurConnexion implements ActionListener {

	private IHMConnexion vue;
	private Proprietaire modele;

	public controleurConnexion(IHMConnexion vue) {
		this.vue = vue;
		this.modele = new Proprietaire();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton actionCommand = (JButton) e.getSource();
		switch (actionCommand.getActionCommand()) {
		case "Inscription":
			IHMInscription vueInscription = new IHMInscription();
			vueInscription.setVisible(true);
			this.vue.dispose();
			break;
		case "Valider":
			String identifiant = vue.getIdentifiant();
			String motDePasse = vue.getMotDePasse();

			if (identifiant.isEmpty() || motDePasse.isEmpty()) {
				vue.afficherMessageErreur("Les champs identifiant et mot de passe ne doivent pas être vides.");
				return;
			}
			if (connecterALaBaseDeDonnees(identifiant, motDePasse)) {
				JOptionPane.showMessageDialog(vue, "Connexion réussie à la base de données !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
				IHMAccueil vueAccueil = new IHMAccueil();
				vueAccueil.setVisible(true);
				vue.dispose();
			} else {
				vue.afficherMessageErreur("Échec de la connexion. Veuillez vérifier vos informations.");
			}
			break;
		case "Annuler":
			this.vue.dispose();
			break;
		}
	}

	public boolean connecterALaBaseDeDonnees(String idProprietaire, String motDePasse) {
		return this.modele.getProprietaireByCredentials(idProprietaire, motDePasse) != null;
	}
}
