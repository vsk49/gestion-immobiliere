package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.JDBCProprietaire;
import vue.IHMConnexion;
import vue.IHMInscription;

import modele.Proprietaire;

public class ControleurInscription implements ActionListener {

	private final IHMInscription vue;
	private final JDBCProprietaire bd = new JDBCProprietaire();

	public ControleurInscription(IHMInscription vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = ((JButton) e.getSource()).getActionCommand();
		if (actionCommand.equals("Valider")) {
			String identifiant = vue.getIdentifiant();
			String motDePasse = vue.getMotDePasse();
			if (identifiant.isEmpty() || motDePasse.isEmpty()) {
				vue.afficherMessageErreur("Les champs identifiant et mot de passe ne doivent pas être vides.");
				return;
			}
			validerInscription(identifiant, motDePasse);
		} else {
			annulerInscription();
		}
	}
	
	private void validerInscription(String identifiant, String motDePasse) {
		if (this.bd.insert(new Proprietaire(identifiant, motDePasse))) {
			vue.afficherMessageSucces("Inscription réussie !");
			IHMConnexion vueConnexion = new IHMConnexion();
			vueConnexion.setVisible(true);
			vue.dispose();
		} else {
			vue.afficherMessageErreur("Erreur inscription: L'utilisateur existant");
		}
	}

	private void annulerInscription() {
		IHMConnexion vueConnexion = new IHMConnexion();
		vueConnexion.setVisible(true);
		vue.dispose();
	}

}
