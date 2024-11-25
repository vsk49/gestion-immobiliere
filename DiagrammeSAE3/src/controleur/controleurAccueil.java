package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.*;
import vue.IHMAccueil;

public class controleurAccueil implements ActionListener {

	private IHMAccueil vue;
	
	public controleurAccueil () {
		this.vue = Main.g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
        case "ajouterLocataire" :
			 	
        case "ajouterBien" :
			
        case "ajouterBail" :
			
        case "faireDeclarationFiscale" :
			
        case "voirFinances" :
			
		}
		
	}
}
