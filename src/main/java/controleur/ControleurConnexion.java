package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.JDBCProprietaire;
import modele.Proprietaire;
import vue.IHMAccueil;
import vue.IHMConnexion;
import vue.IHMInscription;

public class ControleurConnexion extends MouseAdapter implements ActionListener  {

	private final IHMConnexion vue;
	private final JDBCProprietaire modele;

	public ControleurConnexion(IHMConnexion vue) {
		this.vue = vue;
		this.modele = new JDBCProprietaire();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton actionCommand = (JButton) e.getSource();

		// fermer la fenêtre
		if (actionCommand.getText().equals("Annuler"))
			this.vue.dispose();
		
		String identifiant = vue.getIdentifiant();
		String motDePasse = vue.getMotDePasse();
		// Vérification des champs
		if (identifiant.isEmpty() || motDePasse.isEmpty()) {
			vue.afficherMessageErreur("Les champs identifiant et mot de passe ne doivent pas être vides.");
			return;
		}
		validerConnexion(identifiant, motDePasse);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		IHMInscription vueInscription = new IHMInscription();
		vueInscription.setVisible(true);
		this.vue.dispose();
	}

	private void validerConnexion(String identifiant, String motDePasse) {
		// Récupération des informations saisies
		Proprietaire proprietaire = new Proprietaire(identifiant, motDePasse);
		if (!this.modele.isPresentInformationProprietaire(identifiant)) {
			vue.afficherMessageErreur("Échec de la connexion. Identifiant incorrecte.");
			return;
		}
		// comparaison des valeurs dans la BD.
		Proprietaire p = this.modele.getById(identifiant).orElseThrow();
		if (p.equals(proprietaire)) {
			JOptionPane.showMessageDialog(vue, "Connexion réussie à la base de données !", "Succès",
					JOptionPane.INFORMATION_MESSAGE);
			IHMAccueil vueAccueil = new IHMAccueil();
			vueAccueil.setVisible(true);
			vue.dispose();
		} else {
			vue.afficherMessageErreur("Échec de la connexion. Mot de passe incorrecte.");
		}
	}

}
