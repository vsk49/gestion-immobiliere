package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import vue.IHMRegularisationCharges;
import vue.IHMPopupAjusterProvisions;

public class controleurPopupAjusterProvisions implements ActionListener{

    private IHMPopupAjusterProvisions vue;
    
    public controleurPopupAjusterProvisions (IHMPopupAjusterProvisions vue) {
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Annuler" :
        case "Valider" :
            IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
            vueRegularisationCharges.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }   
}
