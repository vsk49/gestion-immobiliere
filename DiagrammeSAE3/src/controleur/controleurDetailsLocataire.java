package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.IHMDetailsLocataire;

public class controleurDetailsLocataire implements ActionListener {

	private IHMDetailsLocataire vue;
	
	public controleurDetailsLocataire (IHMDetailsLocataire vue) {
		this.vue = vue;
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
