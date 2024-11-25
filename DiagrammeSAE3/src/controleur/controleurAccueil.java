package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.IHMAjouterLocataire;

public class controleurAccueil implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
        case "ajouterLocataire" :
			IHMAjouterLocataire vueAjouterLocataire = new IHMAjouterLocataire();
			vueAjouterLocataire.setVisible(true);
			break;
		}
		
	}
}
