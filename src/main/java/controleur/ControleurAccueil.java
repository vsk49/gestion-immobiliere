package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vue.IHMAccueil;
import vue.IHMAjouterBien;
import vue.IHMAjouterLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;
import java.util.HashMap;
import java.util.Map;

public class ControleurAccueil implements ActionListener {

	private final IHMAccueil vue;
	private final Map<String, GestionMenu> actionHandlers = new HashMap<>();

	public ControleurAccueil(IHMAccueil vue) {
		this.vue = vue;
		initialiserEvenements();
	}

	private void initialiserEvenements() {
		actionHandlers.put("Ajouter Locataire", new AjouterLocataireHandler());
		actionHandlers.put("Ajouter Bien", new AjouterBienHandler());
		// actionHandlers.put("Ajouter Bail", new AjouterBailHandler());
		actionHandlers.put("Mes Locataires", new ConsulterLocatairesHandler());
		actionHandlers.put("Mes Biens", new ConsulterBiensHandler());
		actionHandlers.put("Mes Baux", new ConsulterBauxHandler());
		actionHandlers.put("Déclaration Fiscale", new DeclarationFiscaleHandler());
		actionHandlers.put("Régularisation Charges", new FinancesHandler());
	}

	// interface pour gerer un evenement du menu
	private interface GestionMenu {
		void gererEvenement();
	}

	// pour chaque action du menu, on associe un handler
	private class AjouterLocataireHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMAjouterLocataire vueAjouterLocataire = new IHMAjouterLocataire();
			vueAjouterLocataire.setVisible(true);
			vue.dispose();
		}
	}

	private class AjouterBienHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMAjouterBien vueAjouterBien = new IHMAjouterBien();
			vueAjouterBien.setVisible(true);
			vue.dispose();
		}
	}

//	private class AjouterBailHandler implements GestionMenu {
//		@Override
//		public void gererEvenement() {
//			IHMAjouterBail vueAjouterBail = new IHMAjouterBail();
//			vueAjouterBail.setVisible(true);
//			vue.dispose();
//		}
//	}

	private class ConsulterLocatairesHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
			vueGestionLocataires.setVisible(true);
			vue.dispose();
		}
	}

	private class ConsulterBiensHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
			vueGestionBiens.setVisible(true);
			vue.dispose();
		}
	}

	private class ConsulterBauxHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
			vueGestionBaux.setVisible(true);
			vue.dispose();
		}
	}

	private class DeclarationFiscaleHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
			vueDeclarationFiscale.setVisible(true);
			vue.dispose();
		}
	}

	private class FinancesHandler implements GestionMenu {
		@Override
		public void gererEvenement() {
			IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
			vueRegularisationCharges.setVisible(true);
			vue.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bouton = (JButton) e.getSource();
		GestionMenu handler = this.actionHandlers.get(bouton.getText());
		if (handler != null) {
			handler.gererEvenement();
		} else {
			throw new IllegalArgumentException("Action inconnue: " + bouton.getText());
		}
	}

}