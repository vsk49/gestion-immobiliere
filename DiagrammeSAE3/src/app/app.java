package app;

import java.awt.EventQueue;

import controleur.*;
import vue.*;

public class app {
	
	private static app instance;
	
	public enum vueActuelles {
		ACCUEIL, AJOUTER_BIEN, AJOUTER_LOCATAIRE, AJOUTER_BAIL, DECLARATION_FISCALE,DETAIL_BAIL,
		DETAIL_BIEN, DETAIL_LOCATAIRE, GESTION_BAUX, GESTION_BIENS, GESTION_LOCATAIRES, VIREMENT;
	}
	
	public static synchronized getInstance() {
		if (instance == null) {
			instance = new app();
		}
		return instance;
	}
	
	public vueActuelles vueActuelle;
    
    public setVueActuelle (vueActuelles newVue) {
    	this.vueActuelle = newVue;
    	
    	switch (this.vueActuelle) {
    	case
    	}
    }
}
